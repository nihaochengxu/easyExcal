package com.it.easyexcal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.easyexcal.entity.User;

/**
 * <p>
 * 【会员模块】会员信息 Mapper 接口
 * </p>
 *
 * @author Brave
 * @since 2022-07-01
 */
public interface UserMapper extends BaseMapper<User> {

    User queryUserByid(String uuid);
}
