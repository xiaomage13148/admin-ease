package com.ease.admin.common.filter;

import cn.dev33.satoken.stp.StpUtil;
import com.ease.admin.common.context.UserContext;
import com.ease.admin.common.context.UserContextHolder;
import com.ease.admin.common.utils.IpUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class GenericFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 清理数据，避免线程池化复用残留
        UserContextHolder.clear();

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // TODO 存在问题 非 web 上下文无法获取 HttpServletRequest
        String userId = StpUtil.getLoginId("defaultUserId");
        String clientIp = IpUtil.getIpAddr(httpServletRequest);
        UserContext userContext = UserContext.builder()
                .userId(userId)
                .clientIP(clientIp)
                .build();
        UserContextHolder.setUserContext(userContext);
        chain.doFilter(request, response);
        UserContextHolder.clear();
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
