package com.ease.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ease.admin.adapter.RouteAdapter;
import com.ease.admin.bean.entity.Route;
import com.ease.admin.bean.vo.RouteInfoVo;
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

    @Autowired
    private RouteAdapter routeAdapter;

    @Override
    public List<RouteInfoVo> queryRouteIdList(Set<String> roleIdList) {
        List<String> distinctRouteIdList = routeMapper.queryRouteIdList(roleIdList);
        List<Route> routeList = routeMapper.selectList(
                Wrappers.lambdaQuery(Route.class)
                        .in(Route::getId, distinctRouteIdList)
                        .select(Route::getId, Route::getRouteCode)
        );
        return routeAdapter.buildRouteInfoVoList(routeList);
    }
}
