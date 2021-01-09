package com.bat.jyzh.webflux.webflux.handler;

import com.bat.jyzh.webflux.model.User;
import com.bat.jyzh.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * UserHandler
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 16:48
 **/
@Component
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> getUserList() {
        return Flux.fromIterable(userRepository.getUserList()).delayElements(Duration.ofSeconds(1));
    }

    public Mono<User> getUser(Long id) {
        return Mono.justOrEmpty(userRepository.getUser(id));
    }

    public Mono<User> postUser(User user) {
        return Mono.just(userRepository.postUser(user));
    }

    public Mono<User> delUser(Long id) {
        return Mono.just(userRepository.delUser(id));
    }
}
