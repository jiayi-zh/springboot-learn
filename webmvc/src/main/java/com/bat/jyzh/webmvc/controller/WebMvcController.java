package com.bat.jyzh.webmvc.controller;

import com.bat.jyzh.webmvc.model.User;
import com.bat.jyzh.webmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * MVC Controller
 *
 * @author ZhengYu
 * @version 1.0 2021/1/9 15:08
 **/
@RestController
@RequestMapping("/webmvc")
public class WebMvcController {

    @Autowired
    private UserService userService;

    /**
     * 同步方式执行任务， 注意此时接收用户请求的线程也将阻塞
     *
     * @author ZhengYu
     */
    @GetMapping("/sync")
    public List<User> syncGetAllUser() {
        return userService.queryAllUser();
    }

    @GetMapping("/async")
    public String asyncGetAllUser(HttpServletRequest request) {

        // 开启异步
        AsyncContext asyncContext = request.startAsync();

        // 异步执行任务
        CompletableFuture.runAsync(() -> {
            userService.queryAllUser();
            asyncContext.complete();
        });

        return "success";
    }
}
