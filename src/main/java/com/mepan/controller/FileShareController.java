package com.mepan.controller;

import com.mepan.annotation.GlobalInterceptor;
import com.mepan.annotation.VerifyParam;
import com.mepan.entity.dto.SessionWebUserDto;
import com.mepan.entity.po.FileShare;
import com.mepan.entity.query.FileShareQuery;
import com.mepan.entity.vo.PaginationResultVO;
import com.mepan.entity.vo.ResponseVO;
import com.mepan.service.IFileShareService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 分享信息 前端控制器
 * </p>
 *
 * @author dx
 * @since 2023-08-10
 */
@RestController("fileShareController")
@RequestMapping("/share")
public class FileShareController extends ABaseController {
    @Resource
    private IFileShareService iFileShareService;


    @RequestMapping("/loadShareList")
    @GlobalInterceptor(checkParams = true)
    public ResponseVO loadShareList(HttpSession session, FileShareQuery query) {
        query.setOrderBy("share_time desc");
        SessionWebUserDto userDto = getUserInfoFromSession(session);
        query.setUserId(userDto.getUserId());
        query.setQueryFileName(true);
        PaginationResultVO resultVO = this.iFileShareService.findListByPage(query);
        return getSuccessResponseVO(resultVO);
    }

    @RequestMapping("/shareFile")
    @GlobalInterceptor(checkParams = true)
    public ResponseVO shareFile(HttpSession session,
                                @VerifyParam(required = true) String fileId,
                                @VerifyParam(required = true) Integer validType,
                                String code) {
        SessionWebUserDto userDto = getUserInfoFromSession(session);
        FileShare share = new FileShare();
        share.setFileId(fileId);
        share.setValidType(validType);
        share.setCode(code);
        share.setUserId(userDto.getUserId());
        iFileShareService.saveShare(share);
        return getSuccessResponseVO(share);
    }

    @RequestMapping("/cancelShare")
    @GlobalInterceptor(checkParams = true)
    public ResponseVO cancelShare(HttpSession session, @VerifyParam(required = true) String shareIds) {
        SessionWebUserDto userDto = getUserInfoFromSession(session);
        iFileShareService.deleteFileShareBatch(shareIds.split(","), userDto.getUserId());
        return getSuccessResponseVO(null);
    }
}
