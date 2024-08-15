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
 * 权限表
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("permission")
public class Permission extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 权限代码
     */
    @TableField("permission_code")
    private String permissionCode;

    /**
     * 权限名称
     */
    @TableField("permission_name")
    private String permissionName;
}
