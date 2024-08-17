package com.ease.admin.service;

import com.ease.admin.bean.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author xiaomage
 * @since 2024-08-14
 */
public interface RoleService extends IService<Role> {
    /**
     * 查询角色ID列表
     *
     * @param userId
     * @return
     */
    Set<String> queryRoleIdList(String userId);
}
