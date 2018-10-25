package com.lvmama.redis.service.impl;

import com.lvmama.redis.entry.User;
import com.lvmama.redis.service.UserService;
import com.lvmama.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean setUser(User user) {
           return redisUtil.set(user.getUserId().toString(),user);

    }
}
