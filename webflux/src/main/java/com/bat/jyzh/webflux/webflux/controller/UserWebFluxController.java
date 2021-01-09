package com.bat.jyzh.webflux.webflux.controller;

import com.bat.jyzh.webflux.model.User;
import com.bat.jyzh.webflux.webflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * WebFlux Controller
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 17:03
 **/
@RestController
@RequestMapping("/webflux")
public class UserWebFluxController {

    @Autowired
    private UserHandler userHandler;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUserList() {
        return userHandler.getUserList();
    }


    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return userHandler.getUser(id);
    }

    @PostMapping
    public Mono<User> postUser(@RequestBody User user) {
        return userHandler.postUser(user);
    }

    @DeleteMapping("/{id}")
    public Mono<User> delUser(@PathVariable Long id) {
        return userHandler.delUser(id);
    }
}