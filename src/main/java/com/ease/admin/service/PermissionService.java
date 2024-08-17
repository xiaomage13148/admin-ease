package com.ease.admin.service;

import com.ease.admin.bean.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ease.admin.bean.vo.RouteInfoVo;

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
     * @param routeInfoVoList
     * @return
     */
    List<String> queryPermissionCodeList(List<RouteInfoVo> routeInfoVoList);
}
