package com.ease.admin.common.bean.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    /**
     * 主键id
     */
    @TableId("id")
    private String id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    /**
     * 更新者
     */
    @TableField(value = "updater", fill = FieldFill.INSERT_UPDATE)
    private String updater;

    /**
     * 是否删除 0未删除 1已删除
     */
    @TableLogic(delval = "1", value = "0")
    @TableField("deleted")
    private Boolean deleted;
}
