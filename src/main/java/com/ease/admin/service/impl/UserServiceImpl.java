package com.ease.admin.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ease.admin.adapter.UserAdapter;
import com.ease.admin.bean.dto.UserLoginDto;
import com.ease.admin.bean.dto.UserRegisterDto;
import com.ease.admin.bean.entity.User;
import com.ease.admin.bean.vo.UserVo;
import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.exception.CustomException;
import com.ease.admin.common.utils.PasswordUtil;
import com.ease.admin.mapper.UserMapper;
import com.ease.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        userRegisterDto.setPassword(PasswordUtil.hashPassword(userRegisterDto.getPassword()));
        User user = userAdapter.buildUserEntity(userRegisterDto);
        int insert = userMapper.insert(user);
        if (insert == 0) {
            throw new CustomException(ResultEnum.USER_REGISTER_EXCEPTION);
        }
    }

    @Override
    public Long countUserByUsername(String username) {
        return userMapper.selectCount(Wrappers.lambdaQuery(User.class).eq(User::getUsername, username));
    }

    @Override
    public String userLogin(UserLoginDto userLoginDto) {
        boolean login = StpUtil.isLogin();
        if (login) {
            return StpUtil.getTokenInfo().getTokenValue();
        }
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        List<User> userList = userMapper.selectList(Wrappers.lambdaQuery(User.class)
                .eq(User::getUsername, username)
                .select(User::getUsername, User::getPassword, User::getId)
        );
        if (CollectionUtil.isEmpty(userList)) {
            throw new CustomException(ResultEnum.USER_NOT_REGISTER_EXCEPTION);
        }
        if (userList.size() > 1) {
            throw new CustomException(ResultEnum.USER_LOGIN_DATA_EXCEPTION);
        }
        User user = userList.get(0);
        String encPassword = user.getPassword();
        Boolean verified = PasswordUtil.verifyPassword(password, encPassword);
        if (!verified) {
            throw new CustomException(ResultEnum.USER_LOGIN_PASSWORD_EXCEPTION);
        }
        String userId = user.getId();
        StpUtil.login(userId);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return tokenInfo.getTokenValue();
    }

    @Override
    public List<UserVo> queryAllUser() {
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery(User.class));
        return userAdapter.buildUserVoList(users);
    }
}
