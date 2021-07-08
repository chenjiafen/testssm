package com.tensquare.gathering.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenjiafeng2
 * @create 2021-07-07 13:57
 * @desc 管理员库
 **/
@Data
@AllArgsConstructor
public class Admin {
    private  String id;
    private String loginname;
    private String password;
    private String state;
}
