package com.ease.admin.common.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.ease.admin.common.constant.Constant;
import com.ease.admin.common.filter.CustomSaServletFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * Sa-Token 配置类
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/15 下午3:10 <br/>
 * @since JDK 17
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    @Bean
    @Primary
    public SaTokenConfig getSaTokenConfigPrimary() {
        SaTokenConfig config = new SaTokenConfig();
        config.setTokenName(Constant.TOKEN_HEADER); // token 名称（同时也是 cookie 名称）
        config.setTimeout(Constant.DEFAULT_EXPIRE); // token 有效期（单位：秒），默认30天，-1代表永不过期
        config.setActiveTimeout(-1); // token 最低活跃频率（单位：秒），如果 token 超过此时间没有访问系统就会被冻结，默认-1 代表不限制，永不冻结
        config.setIsConcurrent(true); // 是否允许同一账号多地同时登录（为 true 时允许一起登录，为 false 时新登录挤掉旧登录）
        config.setIsShare(true); // 在多人登录同一账号时，是否共用一个 token （为 true 时所有登录共用一个 token，为 false 时每次登录新建一个 token）
        config.setTokenStyle("random-32"); // token 风格
        config.setIsLog(true); // 是否输出操作日志
        return config;
    }

    @Bean
    public SaServletFilter getSaServletFilter() {
        // 参考
        return new CustomSaServletFilter()
                .addInclude("/**").addExclude(
                        "/favicon.ico",
                        "/doc.html",
                        "/doc.html*",
                        "/webjars/**",
                        "/img.icons/**",
                        "/swagger-resources/**",
                        "/v3/api-docs/**")
                .setAuth(obj -> {
                    SaRouter.match("/**")
                            .notMatch("/login/userLogin", "/register/userRegister")
                            .check(r -> StpUtil.checkLogin());
                })
                .setError(e -> {
                    log.warn("setError 触发...");
                    return e;
                })
                .setBeforeAuth(r -> {
                    SaHolder.getResponse()
                            // 服务器名称
                            .setServer("admin-ease")
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                    // 预检请求 立马放行
                    SaRouter.match(SaHttpMethod.OPTIONS).back();
                });
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
