package com.ease.admin.controller;

import com.ease.admin.bean.dto.UserRegisterDto;
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
@RequestMapping("/register")
@Tag(name = "用户注册相关")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户注册")
    @PostMapping("/userRegister")
    public BaseResp<Object> userRegister(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        String username = userRegisterDto.getUsername();
        Long userCount = userService.countUserByUsername(username);
        if (userCount > 0) {
            return new BaseResp<>(ResultEnum.UNKNOWN_EXCEPTION.getState(), "该用户名已注册，请尝试其他用户名");
        }
        userService.userRegister(userRegisterDto);
        return new BaseResp<>(ResultEnum.SUCCESS);
    }
}
