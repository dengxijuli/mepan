package com.mepan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mepan.entity.po.FileInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文件信息 Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2023-08-06
 */
public interface FileInfoMapper<P> extends BaseMapper<FileInfo> {

    Long selectUseSpace(String userId);

    /**
     * selectList:(根据参数查询集合). <br/>
     */
    List<FileInfo> selectListByParam(@Param("query") P p);


    void updateFileStatusWithOldStatus(@Param("fileId") String fileId, @Param("userId") String userId, @Param("bean") FileInfo t,
                                       @Param("oldStatus") Integer oldStatus);

    Integer selectCountByParam(@Param("query") P p);

    void updateFileDelFlagBatch(@Param("bean") FileInfo fileInfo,
                                @Param("userId") String userId,
                                @Param("filePidList") List<String> filePidList,
                                @Param("fileIdList") List<String> fileIdList,
                                @Param("oldDelFlag") Integer oldDelFlag);

    void delFileBatch(@Param("userId") String userId,
                      @Param("filePidList") List<String> filePidList,
                      @Param("fileIdList") List<String> fileIdList,
                      @Param("oldDelFlag") Integer oldDelFlag);

    Integer insertBatch(@Param("list") List<FileInfo> list);
}
