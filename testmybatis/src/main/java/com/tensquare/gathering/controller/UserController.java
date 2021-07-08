package com.tensquare.gathering.controller;

import com.tensquare.gathering.entity.User;
import com.tensquare.gathering.service.UserService;
import com.tensquare.gathering.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author chenjiafeng2
 * @create 2021-07-06 14:17
 * @desc 用户
 **/

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        //如果对象为空
        if (Objects.isNull(user.getMobile())&& Objects.isNull(user.getPassword())) {
            return new Result(false, 500, "参数不能为空");
        }
        User login = userService.login(user);
        if(login !=null){
            return new Result(true, 200, "查询成功", login);
        }else {
            return new Result(false,500,"用户名或密码错 误");
        }

    }
    /**
     * 增加
     * @param user
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user  ){
        userService.add(user);
        return new Result(true,200,"增加成功");
    }



}
