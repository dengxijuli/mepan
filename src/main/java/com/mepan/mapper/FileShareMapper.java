package com.mepan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mepan.entity.po.FileShare;
import com.mepan.entity.query.FileShareQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 分享信息 Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2023-08-10
 */
public interface FileShareMapper extends BaseMapper<FileShare> {

    Integer selectCountByParam(@Param("query") FileShareQuery param);

    List<FileShare> selectListByParam(@Param("query") FileShareQuery param);

    Integer deleteFileShareBatch(@Param("shareIdArray") String[] shareIdArray, @Param("userId") String userId);

    void updateShareShowCount(@Param("shareId") String shareId);
}
