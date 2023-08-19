package com.mepan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mepan.entity.dto.SessionWebUserDto;
import com.mepan.entity.po.FileInfo;
import com.mepan.entity.po.UserInfo;
import com.mepan.entity.query.UserInfoQuery;
import com.mepan.entity.vo.PaginationResultVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */
@Service
public interface IUserInfoService extends IService<UserInfo> {

    List<UserInfo> findListByParam(UserInfoQuery userInfoQuery);

    SessionWebUserDto login(String email, String password);

    void register(String email, String nickName, String password, String emailCode);

    void resetPwd(String email, String password, String emailCode);

    SessionWebUserDto qqLogin(String code);


    void updateUserStatus(String userId, Integer status);

    void changeUserSpace(String userId, Integer changeSpace);

    PaginationResultVO<UserInfo> findListByPage(UserInfoQuery param);

    UserInfo getUserInfoByUserId(String userId);
}
