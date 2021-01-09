package com.bat.jyzh.webflux.repository;

import com.bat.jyzh.webflux.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * {@link com.bat.jyzh.webflux.model.User} Repository
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 16:40
 **/
@Repository
public class UserRepository {

    private static final Map<Long, User> MEMORY_CACHE = new ConcurrentHashMap<>();
    private static final AtomicLong ID_INCR = new AtomicLong();

    public Collection<User> getUserList() {
        return MEMORY_CACHE.values();
    }

    public User getUser(Long id) {
        return MEMORY_CACHE.get(id);
    }

    public User postUser(User user) {
        user.setId(ID_INCR.getAndIncrement());
        MEMORY_CACHE.put(user.getId(), user);
        return user;
    }

    public User delUser(Long id) {
        User old = getUser(id);
        if (old != null) {
            MEMORY_CACHE.remove(id);
        }
        return old;
    }
}
