package com.ease.admin.bean.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户vo")
public class UserVo {
    @Schema(title = "用户名")
    private String username;

    @Schema(title = "昵称")
    private String nickname;

    @Schema(title = "头像url")
    private String headImage;
}
