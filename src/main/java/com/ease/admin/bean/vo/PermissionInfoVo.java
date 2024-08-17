package com.ease.admin.bean.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "权限信息Vo")
public class PermissionInfoVo {
    @Schema(title = "路由ID")
    private String routeId;


    @Schema(title = "权限代码")
    private String permissionCode;
}
