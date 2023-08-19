package com.mepan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mepan.component.RedisComponent;
import com.mepan.entity.config.AppConfig;
import com.mepan.entity.constants.Constants;
import com.mepan.entity.dto.SysSettingsDto;
import com.mepan.entity.po.EmailCode;
import com.mepan.entity.po.UserInfo;
import com.mepan.exception.BusinessException;
import com.mepan.mapper.EmailCodeMapper;
import com.mepan.mapper.UserInfoMapper;
import com.mepan.service.IEmailCodeService;
import com.mepan.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


/**
 * <p>
 * 邮箱验证码 服务实现类
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */
@Service
public class EmailCodeServiceImpl extends ServiceImpl<EmailCodeMapper, EmailCode> implements IEmailCodeService {

    private static final Logger logger = LoggerFactory.getLogger(EmailCodeServiceImpl.class);

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private EmailCodeMapper emailCodeMapper;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private AppConfig appConfig;
    @Resource
    private RedisComponent redisComponent;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendEmailCode(String email, Integer type) {
        if (type.equals(Constants.ZERO)) {
            UserInfo userInfo = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("email", email));
            if (userInfo != null) {
                throw new BusinessException("邮箱已经存在");
            }
        }
        String code = StringTools.getRandomString(Constants.LENGTH_5);

        //把之前的验证码更新为不可用
        emailCodeMapper.disableEmailCode(email);
        //发送验证码
        sendEmailCode(email, code);

        EmailCode emailCode = new EmailCode();
        emailCode.setCode(code);
        emailCode.setEmail(email);
        emailCode.setStatus(Constants.ZERO);
        emailCode.setCreateTime(LocalDateTime.now());
        emailCodeMapper.insert(emailCode);

    }

    private void sendEmailCode(String toEmail, String code) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //邮件发件人
            helper.setFrom(appConfig.getSendUserName());
            //邮件收件人 1或多个
            helper.setTo(toEmail);

            SysSettingsDto sysSettingsDto = redisComponent.getSysSettingsDto();

            //邮件主题
            helper.setSubject(sysSettingsDto.getRegisterEmailTitle());
            //邮件内容
            helper.setText(String.format(sysSettingsDto.getRegisterEmailContent(), code));
            //邮件发送时间
            helper.setSentDate(new Date());
            javaMailSender.send(message);
        } catch (Exception e) {
            logger.error("邮件发送失败", e);
            throw new BusinessException("邮件发送失败");
        }
    }

    @Override
    public void checkCode(String email, String code) {
        EmailCode emailCode = emailCodeMapper.selectOne(new QueryWrapper<EmailCode>().eq("code", code).eq("email", email));
        if (null == emailCode) {
            throw new BusinessException("邮箱验证码不正确");
        }
        if (emailCode.getStatus() == 1 || LocalDateTime.now().toEpochSecond(ZoneOffset.ofTotalSeconds(8)) - emailCode.getCreateTime().toEpochSecond(ZoneOffset.ofTotalSeconds(8)) > Constants.LENGTH_15 * 1000 * 60) {
            System.out.println(System.currentTimeMillis());
            System.out.println(emailCode.getCreateTime().toEpochSecond(ZoneOffset.ofTotalSeconds(8)));
            throw new BusinessException("邮箱验证码已失效");
        }
        emailCodeMapper.disableEmailCode(email);
    }


}
