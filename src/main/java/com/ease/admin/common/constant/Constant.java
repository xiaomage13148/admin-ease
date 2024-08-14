package com.ease.admin.common.constant;

/**
 * 常量
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/14 下午5:13 <br/>
 * @since JDK 17
 */
public interface Constant {

    /**
     * 请求头 - token
     */
    String TOKEN_HEADER = "token";

    /**
     * 请求头 - Authorization
     */
    String AUTHORIZATION = "Authorization";

    /**
     * 空字符串
     */
    String EMPTY_STRING = "";

    /**
     * myException
     */
    String MY_EXCEPTION = "myException";

    /**
     * 系统标识
     */
    String SYSTEM_LOGO_TYPE = "admin-ease";

    /**
     * 默认过期时长为24小时，单位：秒
     */
    Long DEFAULT_EXPIRE = 60 * 60 * 24L;

    /**
     * 过期时长为1小时，单位：秒
     */
    Long HOUR_ONE_EXPIRE = 60 * 60 * 1L;

    /**
     * 过期时长为6小时，单位：秒
     */
    Long HOUR_SIX_EXPIRE = 60 * 60 * 6L;

    /**
     * 不设置过期时长
     */
    Long NOT_EXPIRE = -1L;
}
