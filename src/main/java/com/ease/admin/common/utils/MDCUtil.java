package com.ease.admin.common.utils;

import cn.hutool.core.util.StrUtil;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * MDC 工具类
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/9 上午10:29 <br/>
 * @since JDK 17
 */
public class MDCUtil {
    public static final String TRACE_ID_KEY = "traceId";

    private static final String DEFAULT_TRACE_ID_VALUE = "defaultTraceIdValue";

    /**
     * 设置traceId
     */
    public static void setTraceId() {
        MDC.put(TRACE_ID_KEY, generateUUID());
    }

    /**
     * 设置traceId
     *
     * @param traceId
     */
    public static void setTraceId(String traceId) {
        //如果参数为空，则设置默认traceId
        traceId = StrUtil.isBlank(traceId) ? generateUUID() : traceId;
        //将traceId放到MDC中
        MDC.put(TRACE_ID_KEY, traceId);
    }

    /**
     * 获取traceId
     *
     * @return
     */
    public static String getTraceId() {
        //获取
        String traceId = MDC.get(TRACE_ID_KEY);
        //如果traceId为空，则返回默认值
        return StrUtil.isBlank(traceId) ? DEFAULT_TRACE_ID_VALUE : traceId;
    }

    /**
     * 移除traceId
     */
    public static void removeTraceId() {
        MDC.remove(TRACE_ID_KEY);
    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

