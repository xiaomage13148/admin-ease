package com.ease.admin.common.p6spy;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ease.admin.common.context.UserContextHolder;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoggerFormat implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        // 统一日志打印
        if (StringUtils.isNotBlank(sql)) {
            String methodApi = UserContextHolder.getMethodApi();
            log.info("请求API: [{}] -- 消耗时间: [{} ms] -- 当前时间点: [{}] -- 执行SQL: {}", methodApi, elapsed, now, sql.replaceAll("\\s+", " "));
        }
        return "";
    }
}
