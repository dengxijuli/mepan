package com.mepan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mepan.entity.po.UserInfo;
import com.mepan.entity.query.UserInfoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2023-08-03
 */


public interface UserInfoMapper extends BaseMapper<UserInfo> {

    Integer updateUserSpace(@Param("userId") String userId, @Param("useSpace") Long useSpace, @Param("totalSpace") Long totalSpace);

    Integer selectCountByParam(@Param("query") UserInfoQuery param);

    List<UserInfo> findListByParam(@Param("query") UserInfoQuery p);
}
