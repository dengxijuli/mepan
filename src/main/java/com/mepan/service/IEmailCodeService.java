package com.mepan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mepan.entity.po.EmailCode;

/**
 * <p>
 * 邮箱验证码 服务类
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */
public interface IEmailCodeService extends IService<EmailCode> {

    void sendEmailCode(String email, Integer type);

    void checkCode(String email, String code);
}
