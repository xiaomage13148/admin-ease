package com.ease.admin.controller;

import com.ease.admin.bean.vo.UserVo;
import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.bean.vo.response.BaseResp;
import com.ease.admin.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@RestController
@RequestMapping("/admin/user")
@Tag(name = "用户相关")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "查询全部用户")
    @PostMapping("/queryAllUser")
    public BaseResp<List<UserVo>> queryAllUser() {
        List<UserVo> userVoList = userService.queryAllUser();
        return new BaseResp<>(ResultEnum.SUCCESS, userVoList);
    }
}
