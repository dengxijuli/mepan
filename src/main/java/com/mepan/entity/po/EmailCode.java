package com.mepan.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 邮箱验证码
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */
@TableName("email_code")
@ApiModel(value = "EmailCode对象", description = "邮箱验证码")
public class EmailCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("编号")
    private String code;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("0:未使用  1:已使用")
    private Integer status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmailCode{" +
                "email = " + email +
                ", code = " + code +
                ", createTime = " + createTime +
                ", status = " + status +
                "}";
    }
}
