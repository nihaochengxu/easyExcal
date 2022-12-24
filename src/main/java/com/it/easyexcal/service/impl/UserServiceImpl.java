package com.it.easyexcal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.easyexcal.entity.User;
import com.it.easyexcal.mapper.UserMapper;
import com.it.easyexcal.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 【会员模块】会员信息 服务实现类
 * </p>
 *
 * @author Brave
 * @since 2022-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User selectOne(Integer id) {
        User user = new User();
        user.setNickname("sb了");
        return user;
    }
}
