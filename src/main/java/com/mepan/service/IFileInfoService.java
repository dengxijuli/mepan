package com.mepan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mepan.entity.dto.SessionWebUserDto;
import com.mepan.entity.dto.UploadResultDto;
import com.mepan.entity.po.FileInfo;
import com.mepan.entity.query.FileInfoQuery;
import com.mepan.entity.vo.PaginationResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 文件信息 服务类
 * </p>
 *
 * @author dx
 * @since 2023-08-06
 */
public interface IFileInfoService extends IService<FileInfo> {

    Long getUserUseSpace(String userId);

    PaginationResultVO<FileInfo> findListByPage(FileInfoQuery query);

    List<FileInfo> findListByParam(FileInfoQuery param);

    Integer findCountByParam(FileInfoQuery param);

    UploadResultDto uploadFile(SessionWebUserDto webUserDto, String fileId, MultipartFile file, String fileName, String filePid, String fileMd5, Integer chunkIndex, Integer chunks);

    FileInfo getFileInfoByFileIdAndUserId(String realFileId, String userId);

    FileInfo rename(String fileId, String userId, String fileName);

    FileInfo newFolder(String filePid, String userId, String fileName);

    void changeFileFolder(String fileIds, String filePid, String userId);

    void removeFile2RecycleBatch(String userId, String fileIds);

    void recoverFileBatch(String userId, String fileIds);

    void delFileBatch(String userId, String fileIds, Boolean adminOp);

    void checkRootFilePid(String fileId, String shareUserId, String rootFilePid);

    void saveShare(String shareRootFilePid, String shareFileIds, String myFolderId, String shareUserId, String cureentUserId);

}
