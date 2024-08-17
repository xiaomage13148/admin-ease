package com.ease.admin.service;

import com.ease.admin.bean.entity.Route;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ease.admin.bean.vo.RouteInfoVo;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 路由表 服务类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
public interface RouteService extends IService<Route> {
    /**
     * 查询路由ID列表
     *
     * @param roleIdList
     * @return
     */
    List<RouteInfoVo> queryRouteIdList(Set<String> roleIdList);
}
