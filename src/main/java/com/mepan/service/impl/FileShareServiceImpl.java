package com.mepan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mepan.entity.constants.Constants;
import com.mepan.entity.dto.SessionShareDto;
import com.mepan.entity.enums.PageSize;
import com.mepan.entity.enums.ResponseCodeEnum;
import com.mepan.entity.enums.ShareValidTypeEnums;
import com.mepan.entity.po.FileShare;
import com.mepan.entity.query.FileShareQuery;
import com.mepan.entity.query.SimplePage;
import com.mepan.entity.vo.PaginationResultVO;
import com.mepan.exception.BusinessException;
import com.mepan.mapper.FileShareMapper;
import com.mepan.service.IFileShareService;
import com.mepan.utils.DateUtil;
import com.mepan.utils.StringTools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 分享信息 服务实现类
 * </p>
 *
 * @author dx
 * @since 2023-08-10
 */
@Service
public class FileShareServiceImpl extends ServiceImpl<FileShareMapper, FileShare> implements IFileShareService {

    @Resource
    private FileShareMapper fileShareMapper;


    //分页查询
    @Override
    public PaginationResultVO<FileShare> findListByPage(FileShareQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();
        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<FileShare> list = this.findListByParam(param);
        PaginationResultVO<FileShare> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    @Override
    public Integer findCountByParam(FileShareQuery param) {
        return this.fileShareMapper.selectCountByParam(param);
    }

    @Override
    public List<FileShare> findListByParam(FileShareQuery param) {
        return this.fileShareMapper.selectListByParam(param);
    }

    @Override
    public void saveShare(FileShare share) {
        ShareValidTypeEnums typeEnum = ShareValidTypeEnums.getByType(share.getValidType());
        if (null == typeEnum) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        if (typeEnum != ShareValidTypeEnums.FOREVER) {
            share.setExpireTime(DateUtil.getAfterDate(typeEnum.getDays()));
        }
        share.setShareTime(LocalDateTime.now());
        if (StringTools.isEmpty(share.getCode())) {
            share.setCode(StringTools.getRandomString(Constants.LENGTH_5));
        }
        share.setShareId(StringTools.getRandomString(Constants.LENGTH_20));
        this.fileShareMapper.insert(share);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFileShareBatch(String[] shareIdArray, String userId) {
        Integer count = this.fileShareMapper.deleteFileShareBatch(shareIdArray, userId);
        if (count != shareIdArray.length) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
    }

    @Override
    public FileShare getFileShareByShareId(String shareId) {
        return fileShareMapper.selectOne(new QueryWrapper<FileShare>().eq("share_id", shareId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SessionShareDto checkShareCode(String shareId, String code) {
        FileShare share = fileShareMapper.selectOne(new QueryWrapper<FileShare>()
                        .eq("share_id", shareId));
        if (null == share || (share.getExpireTime() != null && LocalDateTime.now().isAfter(share.getExpireTime()))) {
            throw new BusinessException(ResponseCodeEnum.CODE_902);
        }
        if (!share.getCode().equals(code)) {
            throw new BusinessException("提取码错误");
        }
        //更新浏览次数
        this.fileShareMapper.updateShareShowCount(shareId);
        SessionShareDto shareSessionDto = new SessionShareDto();
        shareSessionDto.setShareId(shareId);
        shareSessionDto.setShareUserId(share.getUserId());
        shareSessionDto.setFileId(share.getFileId());
        shareSessionDto.setExpireTime(share.getExpireTime());
        return shareSessionDto;
    }
}
