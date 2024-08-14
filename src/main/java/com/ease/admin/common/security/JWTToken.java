package com.ease.admin.common.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 封装token , 代替原生的shiro token
 * Description: <br/>
 *
 * @author mjh8 <br/>
 * @date: 2024/8/14 下午5:22 <br/>
 * @since JDK 17
 */
public class JWTToken implements AuthenticationToken {

    private String jwtToken;

    public JWTToken(String token) {
        this.jwtToken = token;
    }

    @Override
    public Object getPrincipal() {
        return jwtToken;
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }
}
