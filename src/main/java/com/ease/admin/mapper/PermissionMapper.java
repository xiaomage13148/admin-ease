package com.ease.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ease.admin.bean.entity.Permission;
import com.ease.admin.bean.vo.PermissionInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询权限代码
     *
     * @param routeIdList
     * @return
     */
    List<PermissionInfoVo> queryPermissionCodeList(@Param("routeIdList") List<String> routeIdList);
}
