DROP DATABASE IF EXISTS `admin-ease`;
CREATE DATABASE IF NOT EXISTS `admin-ease`;
USE `admin-ease`;

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    `id`          VARCHAR(32)   NOT NULL COMMENT '主键ID',
    `username`    VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`    VARCHAR(255)  NOT NULL DEFAULT '' COMMENT '昵称',
    `head_image`  VARCHAR(1023) NOT NULL DEFAULT '' COMMENT '头像url',
    `creator`     VARCHAR(32)   NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` DATETIME      NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`     VARCHAR(32)   NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time` DATETIME      NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`     TINYINT(1)    NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '用户表';

DROP TABLE IF EXISTS role;
CREATE TABLE role
(
    `id`          VARCHAR(32)  NOT NULL COMMENT '主键ID',
    `role_name`   VARCHAR(255) NOT NULL DEFAULT '' COMMENT '角色名称',
    `role_level`  INT          NOT NULL DEFAULT 0 COMMENT '角色等级',
    `creator`     VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`     VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time` DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`     TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '角色表';

DROP TABLE IF EXISTS route;
CREATE TABLE route
(
    `id`              VARCHAR(32)  NOT NULL COMMENT '主键ID',
    `route_code`      VARCHAR(255) NOT NULL DEFAULT '' COMMENT '路由代码',
    `route_value`     VARCHAR(255) NOT NULL DEFAULT '' COMMENT '路由路径',
    `route_component` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '路由对应组件',
    `route_type`      VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '路由类型 1 普通路由 2 菜单路由',
    `parent_route_id` VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '父路由ID',
    `creator`         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time`     DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time`     DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`         TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '路由表';

DROP TABLE IF EXISTS permission;
CREATE TABLE permission
(
    `id`              VARCHAR(32)  NOT NULL COMMENT '主键ID',
    `permission_code` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '权限代码',
    `permission_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '权限名称',
    `creator`         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time`     DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`         VARCHAR(32)  NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time`     DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`         TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '权限表';

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    `id`          VARCHAR(32) NOT NULL COMMENT '主键ID',
    `user_id`     VARCHAR(32) NOT NULL COMMENT '用户ID',
    `role_id`     VARCHAR(32) NOT NULL COMMENT '角色ID',
    `creator`     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time` DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`     TINYINT(1)  NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '用户-角色关联表';


CREATE INDEX idx_user_id ON user_role (user_id);
CREATE INDEX idx_role_id ON user_role (role_id);

DROP TABLE IF EXISTS role_route;
CREATE TABLE role_route
(
    `id`          VARCHAR(32) NOT NULL COMMENT '主键ID',
    `role_id`     VARCHAR(32) NOT NULL COMMENT '角色ID',
    `route_id`    VARCHAR(32) NOT NULL COMMENT '路由ID',
    `creator`     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time` DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`     TINYINT(1)  NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '角色-路由关联表';


CREATE INDEX idx_role_id ON role_route (role_id);
CREATE INDEX idx_route_id ON role_route (route_id);

DROP TABLE IF EXISTS route_permission;
CREATE TABLE route_permission
(
    `id`            VARCHAR(32) NOT NULL COMMENT '主键ID',
    `route_id`      VARCHAR(32) NOT NULL COMMENT '路由ID',
    `permission_id` VARCHAR(32) NOT NULL COMMENT '权限ID',
    `creator`       VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time`   DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`       VARCHAR(32) NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time`   DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`       TINYINT(1)  NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '路由-权限关联表';


CREATE INDEX idx_route_id ON route_permission (route_id);
CREATE INDEX idx_permission_id ON route_permission (permission_id);

DROP TABLE IF EXISTS super_admin;
CREATE TABLE super_admin
(
    `id`          VARCHAR(32) NOT NULL COMMENT '主键ID',
    `user_id`     VARCHAR(32) NOT NULL COMMENT '用户ID',
    `creator`     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    `updater`     VARCHAR(32) NOT NULL DEFAULT '' COMMENT '修改人',
    `update_time` DATETIME    NOT NULL DEFAULT current_timestamp COMMENT '修改时间',
    `deleted`     TINYINT(1)  NOT NULL DEFAULT 0 COMMENT '是否删除  0 未删除 1 已删除',
    PRIMARY KEY (id)
) COMMENT = '超级管理员表';


CREATE UNIQUE INDEX idx_user_id ON super_admin (user_id);



