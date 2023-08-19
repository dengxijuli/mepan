package com.mepan.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */
@TableName("user_info")
@ApiModel(value = "UserInfo对象", description = "")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("qq id 保证用户再次登陆能有记录")
    private String qqOpenId;

    @ApiModelProperty("qq头像")
    private String qqAvatar;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("加入时间")
    private LocalDateTime joinTime;

    @ApiModelProperty("最后登陆时间")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty("0 禁用  1 启用")
    private Integer status;

    @ApiModelProperty("使用空间")
    private Long useSpace;

    @ApiModelProperty("总空间")
    private Long totalSpace;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public String getQqAvatar() {
        return qqAvatar;
    }

    public void setQqAvatar(String qqAvatar) {
        this.qqAvatar = qqAvatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public LocalDateTime getlastLoginTime() {
        return lastLoginTime;
    }

    public void setlastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUseSpace() {
        return useSpace;
    }

    public void setUseSpace(Long useSpace) {
        this.useSpace = useSpace;
    }

    public Long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(Long totalSpace) {
        this.totalSpace = totalSpace;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId = " + userId +
                ", nickName = " + nickName +
                ", email = " + email +
                ", qqOpenId = " + qqOpenId +
                ", qqAvatar = " + qqAvatar +
                ", password = " + password +
                ", joinTime = " + joinTime +
                ", lastLoginTime = " + lastLoginTime +
                ", status = " + status +
                ", useSpace = " + useSpace +
                ", totalSpace = " + totalSpace +
                "}";
    }
}
