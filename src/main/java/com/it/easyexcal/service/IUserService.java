package com.it.easyexcal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.easyexcal.entity.User;
import io.swagger.models.auth.In;

/**
 * <p>
 * 【会员模块】会员信息 服务类
 * </p>
 *
 * @author Brave
 * @since 2022-07-01
 */

public interface IUserService extends IService<User> {
    User selectOne(Integer id);
}
