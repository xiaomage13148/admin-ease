package com.ease.admin.common.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * 密码工具类
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/15 下午4:41 <br/>
 * @since JDK 17
 */
public class PasswordUtil {

    /**
     * 加密密码
     *
     * @param password 需要加密的密码
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * 校验密码
     *
     * @param candidatePassword 需要校验的密码
     * @param hashedPassword 被加密的密码
     */
    public static Boolean verifyPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}