package com.ease.admin.service;

import com.ease.admin.bean.dto.UserLoginDto;
import com.ease.admin.bean.dto.UserRegisterDto;
import com.ease.admin.bean.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ease.admin.bean.vo.UserVo;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userRegisterDto
     */
    void userRegister(UserRegisterDto userRegisterDto);

    /**
     * 根据用户名称统计用户
     *
     * @param username
     * @return
     */
    Long countUserByUsername(String username);

    /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    String userLogin(UserLoginDto userLoginDto);

    /**
     * 查询全部用户
     * @return
     */
    List<UserVo> queryAllUser();
}
