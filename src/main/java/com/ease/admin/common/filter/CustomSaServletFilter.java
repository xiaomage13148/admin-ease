package com.ease.admin.common.filter;

import cn.dev33.satoken.exception.BackResultException;
import cn.dev33.satoken.exception.StopMatchException;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.util.SaTokenConsts;
import com.ease.admin.common.bean.enums.ResultEnum;
import com.ease.admin.common.constant.Constant;
import com.ease.admin.common.exception.CustomException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * 重写SaServletFilter
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/15 下午11:00 <br/>
 * @since JDK 17
 */
@Slf4j
@WebFilter(filterName = "customSaServletFilter")
@Order(SaTokenConsts.ASSEMBLY_ORDER)
public class CustomSaServletFilter extends SaServletFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
//            log.warn("includeList: {}" , includeList);
//            log.warn("excludeList: {}" , excludeList);
            // 执行全局过滤器
            beforeAuth.run(null);
            SaRouter.match(includeList).notMatch(excludeList).check(r -> {
                auth.run(null);
            });

        } catch (StopMatchException e) {
            // StopMatchException 异常代表：停止匹配，进入Controller

        } catch (Throwable e) {
            // 1. 获取异常处理策略结果
            String errMsg = "";
            if (e instanceof BackResultException) {
                errMsg = e.getMessage();
            } else {
                Object err = error.run(e);
                if (err instanceof Throwable) {
                    errMsg = ((Throwable) err).getMessage();
                } else {
                    log.error("CustomSaServletFilter 异常处理异常: {}", err);
                    errMsg = err.toString();
                }
            }
            // 转发到 /myException
            request.setAttribute(Constant.MY_EXCEPTION, new CustomException(ResultEnum.USER_CHECK_LOGIN_EXCEPTION.getState(), ResultEnum.USER_CHECK_LOGIN_EXCEPTION.getMsg() + ":" + errMsg));
            request.getRequestDispatcher("/filter/exception/" + Constant.MY_EXCEPTION).forward(request, response);
            return;
        }

        // 执行
        chain.doFilter(request, response);
    }
}
