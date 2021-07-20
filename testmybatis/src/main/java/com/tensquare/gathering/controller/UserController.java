package com.tensquare.gathering.controller;

import com.tensquare.gathering.entity.User;
import com.tensquare.gathering.service.UserService;
import com.tensquare.gathering.utils.JwtUtil;
import com.tensquare.gathering.utils.Result;
import com.tensquare.gathering.utils.StatusCode;
import freemarker.template.utility.StringUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
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
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    HttpServletRequest request;


    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        //如果对象为空
        if (Objects.isNull(user.getMobile()) && Objects.isNull(user.getPassword())) {
            return new Result(false, 500, "参数不能为空");
        }
        User login = userService.login(user);
        String token = jwtUtil.generateToken(user.getId(), user.getNickname(), "user");
        Map map = new HashMap<>();
        map.put("token", token);
        map.put("name", login.getNickname());
        if (login != null) {

            return new Result(true, 200, "查询成功", map);
        } else {
            return new Result(false, 500, "用户名或密码错 误");
        }

    }

    /**
     * 增加
     *
     * @param user
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, 200, "增加成功");
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        String authHeader = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authHeader)){
            return new Result(false, StatusCode.ACCESSERROR,"权限不足");
        }
        if(!authHeader.startsWith("Bearer ")){
            return new Result(false, StatusCode.ACCESSERROR,"权限不足");
        }
        String token=authHeader.substring(7);
        Claims claims = jwtUtil.parseToken(token);
        if(Objects.isNull(claims)){
            return new Result(false,StatusCode.ACCESSERROR,"权限不足");
        }
       ;
        log.info("========="+ claims.get("role").toString());
        if(!"user".equals(claims.get("role"))){
            return new Result(false,StatusCode.ACCESSERROR,"权限不足");
        }
        userService.deleteById(id);
        return new Result(true, 200, "删除成功");
    }

}
