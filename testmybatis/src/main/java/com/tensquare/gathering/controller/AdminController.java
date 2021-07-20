package com.tensquare.gathering.controller;

import com.tensquare.gathering.entity.Admin;
import com.tensquare.gathering.service.AdminService;
import com.tensquare.gathering.utils.JwtUtil;
import com.tensquare.gathering.utils.Result;
import com.tensquare.gathering.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjiafeng2
 * @create 2021-07-07 15:06
 * @desc 管理员
 **/
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> loginMap) {
            Admin admin = adminService.findByLoginnameAndPassword(loginMap.get("loginname"), loginMap.get("password"));
        if (admin != null) {

           String token= jwtUtil.generateToken(admin.getId(),admin.getLoginname(),"admin");
            Map map=new HashMap();
            map.put("token",token);
            map.put("name",admin.getLoginname());//登陆名
            return new Result(true, StatusCode.OK, "登陆成功",map);
        } else {
            return new Result(false, StatusCode.LOGINERROR, "用户名或密码错 误");
        }

    }
    @PostMapping("/add")
    public Result adminAdd(@RequestBody Admin admin){
        adminService.add(admin);
        return new Result(true,200,"增加成功");
    }
}
