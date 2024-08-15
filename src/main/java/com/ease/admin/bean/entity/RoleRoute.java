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
 * 角色-路由关联表
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("role_route")
public class RoleRoute extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 路由ID
     */
    @TableField("route_id")
    private String routeId;
}
