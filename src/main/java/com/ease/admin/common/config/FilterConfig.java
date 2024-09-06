package com.ease.admin.common.config;

import cn.dev33.satoken.util.SaTokenConsts;
import com.ease.admin.common.filter.CustomSaServletFilter;
import com.ease.admin.common.filter.GenericFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<GenericFilter> registerGenericFilter() {
        FilterRegistrationBean<GenericFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new GenericFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<CustomSaServletFilter> registerCustomSaServletFilter() {
        FilterRegistrationBean<CustomSaServletFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomSaServletFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(SaTokenConsts.ASSEMBLY_ORDER);
        return registrationBean;
    }
}
