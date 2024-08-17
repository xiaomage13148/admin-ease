package com.ease.admin.bean.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "路由信息Vo")
public class RouteInfoVo {

    @Schema(title = "路由ID")
    private String routeId;

    @Schema(title = "路由代码")
    private String routeCode;
}
