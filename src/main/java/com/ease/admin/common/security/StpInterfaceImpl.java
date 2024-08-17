package com.ease.admin.common.security;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 权限认证实现类
 * TODO 待完善..
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/16 下午5:39 <br/>
 * @since JDK 17
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return List.of("user::listAll");
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return List.of();
    }
}
