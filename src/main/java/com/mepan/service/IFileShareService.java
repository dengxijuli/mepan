package com.mepan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mepan.entity.dto.SessionShareDto;
import com.mepan.entity.po.FileShare;
import com.mepan.entity.query.FileShareQuery;
import com.mepan.entity.vo.PaginationResultVO;

import java.util.List;

/**
 * <p>
 * 分享信息 服务类
 * </p>
 *
 * @author dx
 * @since 2023-08-10
 */
public interface IFileShareService extends IService<FileShare> {

    PaginationResultVO<FileShare> findListByPage(FileShareQuery param);

    Integer findCountByParam(FileShareQuery param);

    List<FileShare> findListByParam(FileShareQuery param);

    void saveShare(FileShare share);

    void deleteFileShareBatch(String[] shareIdArray, String userId);

    FileShare getFileShareByShareId(String shareId);

    SessionShareDto checkShareCode(String shareId, String code);
}
