package com.ease.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ease.admin.bean.entity.Role;
import com.ease.admin.bean.entity.RoleRoute;
import com.ease.admin.bean.entity.SuperAdmin;
import com.ease.admin.bean.entity.UserRole;
import com.ease.admin.mapper.RoleMapper;
import com.ease.admin.mapper.RoleRouteMapper;
import com.ease.admin.mapper.SuperAdminMapper;
import com.ease.admin.mapper.UserRoleMapper;
import com.ease.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ease.admin.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private SuperAdminMapper superAdminMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> queryRoleIdList(String userId) {
        // 先从superAdmin表中查询
        Long superAdminCount = superAdminMapper.selectCount(Wrappers.lambdaQuery(SuperAdmin.class).eq(SuperAdmin::getUserId, userId));
        LambdaQueryWrapper<UserRole> queryWrapper = Wrappers.lambdaQuery(UserRole.class);
        // 不是超管
        if (superAdminCount == 0) {
            queryWrapper.eq(UserRole::getUserId, userId);
        }
        List<String> needVerifyRoleIdList = userRoleMapper
                .selectList(queryWrapper.select(UserRole::getRoleId))
                .stream().map(UserRole::getRoleId).distinct().toList();

        return roleMapper
                .selectList(Wrappers.lambdaQuery(Role.class).in(Role::getId, needVerifyRoleIdList).select(Role::getId))
                .stream()
                .map(Role::getId)
                .collect(Collectors.toSet());
    }
}
