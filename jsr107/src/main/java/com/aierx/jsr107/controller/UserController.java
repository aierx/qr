package com.aierx.jsr107.controller;

import com.aierx.jsr107.dao.UserDao;
import com.aierx.jsr107.model.common.Result;
import com.aierx.jsr107.model.po.User;
import com.aierx.jsr107.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/user1")
    public User getUser1(@RequestParam("id")int id) throws Exception {
        return userService.getUser(id);
    }

    @GetMapping("/user2")
    public Result update(@RequestParam("id")String id){
        User user = userService.getUser(1);
        user.setUsername(id);
        userService.updateUser(user);
        return Result.makeSuccess();
    }
}
