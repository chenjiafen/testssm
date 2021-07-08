package com.tensquare.gathering.service;

import com.tensquare.gathering.dao.AdminDao;
import com.tensquare.gathering.entity.Admin;
import com.tensquare.gathering.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author chenjiafeng2
 * @create 2021-07-07 14:16
 * @desc
 **/

@Service
public class AdminService {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    IdWorker idWorker;
    @Autowired
    AdminDao adminDao;

    /**
     * 加密密码
     *
     * @param admin
     */
    public void add(Admin admin) {
        admin.setId(idWorker.nextId() + ""); //主键值
        String newpassword = encoder.encode(admin.getPassword());//加密后
        admin.setPassword(newpassword);
        adminDao.save(admin);
    }

    /**
     * 根据登陆名和密码查询
     * @param loginname
     * @param password
     * @return
     */
    public Admin findByLoginnameAndPassword(String loginname, String password) {
        Admin admin = adminDao.findByLoginname(loginname);
        if (admin != null && encoder.matches(password, admin.getPassword())) {
            return admin;
        } else {
            return null;
        }
    }
}
