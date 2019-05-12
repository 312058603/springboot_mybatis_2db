package com.wpx.service;

import com.wpx.dao.test1.UserDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserSerivce{

    @Resource
    private UserDao userDao1;

    @Override
    public Map<String,Object> selectUserByUserAccount(Map<String,Object> param) {
        Map<String,Object> user=userDao1.selectUserByUserAccount(param);
        return user;
    }

    @Override
    public List<String> selectUserRole(Map<String, Object> param) {
        return userDao1.selectUserRole(param);
    }

    @Override
    public List<String> selectUserPermission(Map<String, Object> param) {
        return userDao1.selectUserPermission(param);
    }


}
