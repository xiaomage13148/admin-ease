package com.ease.admin.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.ease.admin.bean.dto.UserLoginDto;
import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.bean.vo.response.BaseResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "用户登录相关")
public class LoginController {

    @Operation(summary = "用户登录")
    @PostMapping("/userLogin")
    public BaseResp<String> userLogin(@RequestBody @Valid UserLoginDto userLoginDto) {
        // TODO ..生成账户ID
        String id = userLoginDto.getUsername() + "-" + userLoginDto.getPassword();
        StpUtil.login(id);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return new BaseResp<>(ResultEnum.SUCCESS, tokenInfo.getTokenValue());
    }
}
