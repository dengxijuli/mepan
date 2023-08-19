package com.mepan.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件信息
 * </p>
 *
 * @author dx
 * @since 2023-08-06
 */
@TableName("file_info")
@ApiModel(value = "FileInfo对象", description = "文件信息")
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文件ID")
    private String fileId;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("md5值，第一次上传记录")
    private String fileMd5;

    @ApiModelProperty("父级ID")
    private String filePid;

    @ApiModelProperty("文件大小")
    private Long fileSize;

    @ApiModelProperty("文件名称")
    private String fileName;

    @ApiModelProperty("封面")
    private String fileCover;

    @ApiModelProperty("文件路径")
    private String filePath;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("最后更新时间")
    private LocalDateTime lastUpdateTime;

    @ApiModelProperty("0:文件 1:目录")
    private Integer folderType;

    @ApiModelProperty("1:视频 2:音频  3:图片 4:文档 5:其他")
    private Integer fileCategory;

    @ApiModelProperty(" 1:视频 2:音频  3:图片 4:pdf 5:doc 6:excel 7:txt 8:code 9:zip 10:其他")
    private Integer fileType;

    @ApiModelProperty("0:转码中 1转码失败 2:转码成功")
    private Integer status;

    @ApiModelProperty("回收站时间")
    private LocalDateTime recoveryTime;

    @ApiModelProperty("删除标记 0:删除  1:回收站  2:正常")
    private Integer delFlag;

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

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getFilePid() {
        return filePid;
    }

    public void setFilePid(String filePid) {
        this.filePid = filePid;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileCover() {
        return fileCover;
    }

    public void setFileCover(String fileCover) {
        this.fileCover = fileCover;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getFolderType() {
        return folderType;
    }

    public void setFolderType(Integer folderType) {
        this.folderType = folderType;
    }

    public Integer getFileCategory() {
        return fileCategory;
    }

    public void setFileCategory(Integer fileCategory) {
        this.fileCategory = fileCategory;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(LocalDateTime recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId = " + fileId +
                ", userId = " + userId +
                ", fileMd5 = " + fileMd5 +
                ", filePid = " + filePid +
                ", fileSize = " + fileSize +
                ", fileName = " + fileName +
                ", fileCover = " + fileCover +
                ", filePath = " + filePath +
                ", createTime = " + createTime +
                ", lastUpdateTime = " + lastUpdateTime +
                ", folderType = " + folderType +
                ", fileCategory = " + fileCategory +
                ", fileType = " + fileType +
                ", status = " + status +
                ", recoveryTime = " + recoveryTime +
                ", delFlag = " + delFlag +
                "}";
    }
}
