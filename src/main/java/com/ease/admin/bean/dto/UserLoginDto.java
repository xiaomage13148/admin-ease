package com.ease.admin.bean.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(title = "用户登录Dto")
public class UserLoginDto {
    @Schema(title = "用户名称")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(title = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String password;
}
