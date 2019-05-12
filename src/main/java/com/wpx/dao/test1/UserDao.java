package com.wpx.dao.test1;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by GM-KF007 on 2018/9/19.
 */

@Repository("userDao1")
public interface UserDao {

    Map<String,Object> selectUserByUserAccount(Map<String, Object> param);

    List<String> selectUserRole(Map<String, Object> param);

    List<String> selectUserPermission(Map<String, Object> param);

}
