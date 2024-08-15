package com.ease.admin.bean.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(title = "用户注册Dto")
public class UserRegisterDto {
    @Schema(title = "用户名称")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(title = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,20}$", message = "必须包含大小写字母和数字,且长度在8-20之间")
    private String password;
}
