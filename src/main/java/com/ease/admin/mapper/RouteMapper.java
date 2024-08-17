package com.ease.admin.mapper;

import com.ease.admin.bean.entity.Route;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 路由表 Mapper 接口
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
public interface RouteMapper extends BaseMapper<Route> {

    /**
     * 查询路由ID列表
     *
     * @param roleIdList
     * @return
     */
    List<String> queryRouteIdList(@Param("roleIdList") Set<String> roleIdList);
}
