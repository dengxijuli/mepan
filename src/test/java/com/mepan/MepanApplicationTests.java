package com.mepan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mepan.entity.po.UserInfo;
import com.mepan.mapper.EmailCodeMapper;
import com.mepan.mapper.UserInfoMapper;
import com.mepan.service.IEmailCodeService;
import com.mepan.utils.EntityToMapConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class MepanApplicationTests {

    @Resource
    private IEmailCodeService iEmailCodeService;

    @Resource
    private EmailCodeMapper emailCodeMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        emailCodeMapper.disableEmailCode("asdasd");
    }

    @Test
    void test2() {
        UserInfo updateInfo = new UserInfo();
        updateInfo.setlastLoginTime(LocalDateTime.now());
        UserInfo userInfo = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("user_id", "9552937298"));
//        UserInfo userInfo1 = userInfoMapper.selectById("9552937298");
        EntityToMapConverter.convertToMap(userInfo).forEach((k, v) -> System.out.println(k + ":" + v));
//        int i = userInfoMapper.update(updateInfo, new QueryWrapper<UserInfo>());
//        System.out.println(i);
//        int i = userInfoMapper.updateById(updateInfo);
//        System.out.println(i);
    }

    @Test
    void test3() {
        String s = "saasd_asd_asa_a";
        int i = s.lastIndexOf("_");

        System.out.println("i = " + i);

    }

    @Test
    void test4() {
        String s = "saasd_asd_asa_a";
        System.out.println("s.substring(0,1) = " + s.substring(0, 1));
    }

}
