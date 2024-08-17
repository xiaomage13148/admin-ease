package com.ease.admin.adapter;

import com.ease.admin.bean.entity.Route;
import com.ease.admin.bean.vo.RouteInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteAdapter {
    /**
     * 构建 List<RouteInfoVo>
     *
     * @param routeList
     * @return
     */
    public List<RouteInfoVo> buildRouteInfoVoList(List<Route> routeList) {
        return routeList.stream().map(route -> {
            RouteInfoVo routeInfoVo = new RouteInfoVo();
            routeInfoVo.setRouteId(route.getId());
            routeInfoVo.setRouteCode(route.getRouteCode());
            return routeInfoVo;
        }).toList();
    }
}
