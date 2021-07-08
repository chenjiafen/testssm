package com.tensquare.gathering.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tensquare.gathering.dao.UserDao;
import com.tensquare.gathering.entity.Admin;
import com.tensquare.gathering.entity.User;
import com.tensquare.gathering.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author chenjiafeng2
 * @create 2021-07-06 15:15
 * @desc
 **/
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    BCryptPasswordEncoder encoder;//加密
    @Autowired
    IdWorker idWorker;


    //登录方法
    public User login(User user) {
        User loginUser = userDao.findByMobile(user.getMobile());
//        if (loginUser == null) {
//            return null;
//        }
//        //2 使用工具类比对密码是否一致 -> (参数1:明文密码 参数2:密文密码)
//        if (!encoder.matches(user.getPassword(), loginUser.getPassword())) {
//            //不一致 => 密码错误=> 返回null
//            return null;
//        }
//        //3 返回查询到的user
        return loginUser;
    }

    /**
     * 新增用户
     * @param user
     */
    public void add(User user){
        user.setId(idWorker.nextId() + "");
        String newpassword = encoder.encode(user.getPassword());//加密后的
        user.setPassword(newpassword);
        userDao.save(user);
    }

}