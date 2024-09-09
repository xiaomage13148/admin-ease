package com.ease.admin.common.config;

import cn.dev33.satoken.util.SaTokenConsts;
import com.ease.admin.common.filter.CustomSaServletFilter;
import com.ease.admin.common.filter.GenericFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomSaServletFilter> registerCustomSaServletFilter() {
        FilterRegistrationBean<CustomSaServletFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomSaServletFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(SaTokenConsts.ASSEMBLY_ORDER);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<GenericFilter> registerGenericFilter() {
        FilterRegistrationBean<GenericFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new GenericFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
