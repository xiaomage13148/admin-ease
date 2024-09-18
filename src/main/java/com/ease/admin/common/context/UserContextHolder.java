package com.ease.admin.common.context;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * 用户上下文持有类
 *
 * @author mjh8
 * @date 2024/9/6
 */
@Slf4j
public class UserContextHolder {

    private static final ThreadLocal<UserContext> THREAD_LOCAL_CONTEXT = new ThreadLocal<>();


    /**
     * 获取当前用户上下文
     *
     * @return null or 当前用户上下文
     */
    public static UserContext getUserContext() {
        return THREAD_LOCAL_CONTEXT.get();
    }

    /**
     * 获取当前用户上下文
     */
    public static Optional<UserContext> getUserContextOptional() {
        return Optional.ofNullable(THREAD_LOCAL_CONTEXT.get());
    }

    /**
     * 设置当前用户上下文
     *
     * @param newContext 新上下文，传 null 则为清除
     */
    public static void setUserContext(UserContext newContext) {
        if (newContext == null) {
            THREAD_LOCAL_CONTEXT.remove();
            return;
        }

        THREAD_LOCAL_CONTEXT.set(newContext);
    }

    /**
     * 强制清空本线程的用户上下文，防止影响被线程池复用的其他线程，以及内存泄露
     */
    public static void clear() {
        setUserContext(null);
    }

    /**
     * 捷径API-取当前用户ID
     *
     * @return null or 当前用户ID
     */
    public static String getUserId() {
        UserContext context = getUserContext();
        return context == null ? null : context.getUserId();
    }

    /**
     * 捷径API-取当前用户名
     *
     * @return null or 当前用户名
     */
    public static String getUserName() {
        UserContext context = getUserContext();
        return context == null ? null : context.getUserName();
    }

    /**
     * 捷径API-取当前用户手机号
     *
     * @return null or 当前用户手机号
     */
    public static String getUserPhoneNo() {
        UserContext context = getUserContext();
        return context == null ? null : context.getUserPhoneNo();
    }

    /**
     * 捷径API-取当前用户 IP 地址
     *
     * @return null or 当前用户 IP 地址
     */
    public static String getClientIP() {
        UserContext context = getUserContext();
        return context == null ? null : context.getClientIP();
    }

}