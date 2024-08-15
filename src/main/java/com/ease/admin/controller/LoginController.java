package com.ease.admin.controller;

import com.ease.admin.bean.dto.UserLoginDto;
import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.bean.vo.response.BaseResp;
import com.ease.admin.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "用户登录相关")
public class LoginController {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户登录")
    @PostMapping("/userLogin")
    public BaseResp<String> userLogin(@RequestBody @Valid UserLoginDto userLoginDto) {
        String token = userService.userLogin(userLoginDto);
        return new BaseResp<>(ResultEnum.SUCCESS, token);
    }
}
