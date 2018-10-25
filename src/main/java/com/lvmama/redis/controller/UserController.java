package com.lvmama.redis.controller;

import com.lvmama.redis.entry.User;
import com.lvmama.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("setUser")
    @ResponseBody
    public String setUser(User user){
        boolean b = false;
             b = userService.setUser(user);
            if(b){
                return "SUCCESS";
            }
            return "FAIL";
    }
}
