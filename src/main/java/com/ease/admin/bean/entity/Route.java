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
 * 路由表
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("route")
public class Route extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 路由代码
     */
    @TableField("route_code")
    private String routeCode;

    /**
     * 路由路径
     */
    @TableField("route_value")
    private String routeValue;

    /**
     * 路由对应组件
     */
    @TableField("route_component")
    private String routeComponent;

    /**
     * 路由类型 1 普通路由 2 菜单路由
     */
    @TableField("route_type")
    private String routeType;

    /**
     * 父路由ID
     */
    @TableField("parent_route_id")
    private String parentRouteId;
}
