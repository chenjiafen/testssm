package com.tensquare.gathering.dao;

import com.tensquare.gathering.entity.Admin;
import com.tensquare.gathering.entity.Gathering;
import com.tensquare.gathering.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tyler.chen
 * @version 1.0 2020/6/24
 * @date 2020/6/24 0:08
 */
public interface UserDao {
   /**
    * 根据手机号查询
    * @param mobile
    * @return
    */
   User findByMobile(String mobile);

    void save(User user);

    void deleteById(String id);

    /**
    *粉丝数更新
    * @param userid
    * @param count
    */
//   void changeFansCount(String userid, Integer count);

   /**
    * 关注数更新
    * @param userid
    * @param count
    */
//   void changeFollowCount(String userid, Integer count);

}
