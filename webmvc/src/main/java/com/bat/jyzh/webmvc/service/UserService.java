package com.bat.jyzh.webmvc.service;

import com.bat.jyzh.webmvc.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService
 *
 * @author ZhengYu
 * @version 1.0 2021/1/9 15:12
 **/
@Service
public class UserService {

    /**
     * 查询用户列表, 耗时 5 秒
     *
     * @author ZhengYu
     */
    public List<User> queryAllUser() {
        List<User> users = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("jy-zh-" + i);
            user.setAge(0);

            users.add(user);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return users;
    }
}
