package com.ease.admin.service.impl;

import com.ease.admin.bean.entity.Route;
import com.ease.admin.mapper.RouteMapper;
import com.ease.admin.service.RouteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 路由表 服务实现类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
@Service
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route> implements RouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public List<String> queryRouteIdList(Set<String> roleIdList) {
        return routeMapper.queryRouteIdList(roleIdList);
    }
}
