package com.ease.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ease.admin.bean.entity.Permission;
import com.ease.admin.bean.vo.PermissionInfoVo;
import com.ease.admin.bean.vo.RouteInfoVo;
import com.ease.admin.mapper.PermissionMapper;
import com.ease.admin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<String> queryPermissionCodeList(List<RouteInfoVo> routeInfoVoList) {
        List<String> routeIdList = routeInfoVoList.stream().map(RouteInfoVo::getRouteId).toList();
        List<PermissionInfoVo> permissionInfoVoList = permissionMapper.queryPermissionCodeList(routeIdList);
        Map<String, RouteInfoVo> routeIdRouteInfoMap = routeInfoVoList.stream().collect(Collectors.toMap(RouteInfoVo::getRouteId, vo -> vo));
        return permissionInfoVoList.stream().map(permissionInfoVo -> {
            String routeId = permissionInfoVo.getRouteId();
            RouteInfoVo routeInfoVo = routeIdRouteInfoMap.get(routeId);
            if (routeInfoVo == null) {
                return "";
            } else {
                String permissionCode = permissionInfoVo.getPermissionCode();
                String routeCode = routeInfoVo.getRouteCode();
                return routeCode + "::" + permissionCode;
            }
        }).filter(s -> !s.isEmpty()).distinct().toList();
    }
}
