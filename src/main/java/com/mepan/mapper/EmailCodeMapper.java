package com.mepan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mepan.entity.po.EmailCode;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 邮箱验证码 Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */

public interface EmailCodeMapper extends BaseMapper<EmailCode> {

    void disableEmailCode(@Param("email") String email);
}
