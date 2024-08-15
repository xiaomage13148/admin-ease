package com.ease.admin.adapter;

import com.ease.admin.bean.dto.UserRegisterDto;
import com.ease.admin.bean.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {
    /**
     * 构建User实体类
     *
     * @param userRegisterDto
     * @return
     */
    public User buildUserEntity(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUsername(userRegisterDto.getUsername());
        user.setPassword(userRegisterDto.getPassword());
        return user;
    }
}
