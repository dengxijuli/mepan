package com.mepan.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 分享信息
 * </p>
 *
 * @author dx
 * @since 2023-08-10
 */
@TableName("file_share")
@ApiModel(value = "FileShare对象", description = "分享信息")
public class FileShare implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分享ID")
    private String shareId;

    @ApiModelProperty("文件ID")
    private String fileId;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("有效期类型 0:1天 1:7天 2:30天 3:永久有效")
    private Integer validType;

    @ApiModelProperty("失效时间")
    private LocalDateTime expireTime;

    @ApiModelProperty("分享时间")
    private LocalDateTime shareTime;

    @ApiModelProperty("提取码")
    private String code;

    @ApiModelProperty("浏览次数")
    private Integer showCount;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Integer getValidType() {
        return validType;
    }

    public void setValidType(Integer validType) {
        this.validType = validType;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public LocalDateTime getShareTime() {
        return shareTime;
    }

    public void setShareTime(LocalDateTime shareTime) {
        this.shareTime = shareTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }

    @Override
    public String toString() {
        return "FileShare{" +
            "shareId = " + shareId +
            ", fileId = " + fileId +
            ", userId = " + userId +
            ", validType = " + validType +
            ", expireTime = " + expireTime +
            ", shareTime = " + shareTime +
            ", code = " + code +
            ", showCount = " + showCount +
        "}";
    }
}
