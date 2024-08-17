package com.ease.admin.service.impl;

import com.ease.admin.bean.entity.Permission;
import com.ease.admin.mapper.PermissionMapper;
import com.ease.admin.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<String> queryPermissionCodeList(Set<String> routeIdList) {
        return permissionMapper.queryPermissionCodeList(routeIdList);
    }
}
