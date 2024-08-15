package com.ease.admin.bean.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ease.admin.common.bean.entity.BaseEntity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 路由-权限关联表
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("route_permission")
public class RoutePermission extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 路由ID
     */
    @TableField("route_id")
    private String routeId;

    /**
     * 权限ID
     */
    @TableField("permission_id")
    private String permissionId;
}
