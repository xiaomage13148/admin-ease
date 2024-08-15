package com.ease.admin.service.impl;

import com.ease.admin.adapter.UserAdapter;
import com.ease.admin.bean.dto.UserRegisterDto;
import com.ease.admin.bean.entity.User;
import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.exception.CustomException;
import com.ease.admin.mapper.UserMapper;
import com.ease.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAdapter userAdapter;

    @Override
    public void userRegister(UserRegisterDto userRegisterDto) {
        User user = userAdapter.buildUserEntity(userRegisterDto);
        int insert = userMapper.insert(user);
        if (insert == 0) {
            throw new CustomException(ResultEnum.USER_REGISTER_EXCEPTION);
        }
    }
}
