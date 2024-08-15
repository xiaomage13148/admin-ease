package com.ease.admin.adapter;

import com.ease.admin.bean.dto.UserRegisterDto;
import com.ease.admin.bean.entity.User;
import com.ease.admin.bean.vo.UserVo;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * 构建UserVo List
     *
     * @param userList
     * @return
     */
    public List<UserVo> buildUserVoList(List<User> userList) {
        return userList.stream().map(user -> {
            UserVo userVo = new UserVo();
            userVo.setUsername(user.getUsername());
            userVo.setNickname(user.getNickname());
            userVo.setHeadImage(user.getHeadImage());
            return userVo;
        }).toList();
    }
}
