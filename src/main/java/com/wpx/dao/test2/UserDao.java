package com.wpx.dao.test2;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by GM-KF007 on 2018/9/19.
 */

@Repository("userDao2")
public interface UserDao {

    Map<String,Object> selectUserByUserAccount(Map<String, Object> param);

}
