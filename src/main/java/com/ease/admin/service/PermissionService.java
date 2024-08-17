package com.ease.admin.service;

import com.ease.admin.bean.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
public interface PermissionService extends IService<Permission> {
    /**
     * 查询权限代码
     *
     * @param routeIdList
     * @return
     */
    List<String> queryPermissionCodeList(Set<String> routeIdList);
}
