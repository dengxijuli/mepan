package com.mepan.task;

import com.mepan.entity.enums.FileDelFlagEnums;
import com.mepan.entity.po.FileInfo;
import com.mepan.entity.query.FileInfoQuery;
import com.mepan.service.IFileInfoService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileCleanTask {

    @Resource
    private IFileInfoService iFileInfoService;

    @Scheduled(fixedDelay = 1000 * 60 * 3)
    public void execute() {
        FileInfoQuery fileInfoQuery = new FileInfoQuery();
        fileInfoQuery.setDelFlag(FileDelFlagEnums.RECYCLE.getFlag());
        fileInfoQuery.setQueryExpire(true);
        List<FileInfo> fileInfoList = iFileInfoService.findListByParam(fileInfoQuery);
        Map<String, List<FileInfo>> fileInfoMap = fileInfoList.stream().collect(Collectors.groupingBy(FileInfo::getUserId));
        for (Map.Entry<String, List<FileInfo>> entry : fileInfoMap.entrySet()) {
            List<String> fileIds = entry.getValue().stream().map(p -> p.getFileId()).collect(Collectors.toList());
            iFileInfoService.delFileBatch(entry.getKey(), String.join(",", fileIds), false);
        }
    }
}
