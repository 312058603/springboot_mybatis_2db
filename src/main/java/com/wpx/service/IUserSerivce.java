package com.wpx.service;

import java.util.List;
import java.util.Map;

public interface IUserSerivce {

    Map<String,Object> selectUserByUserAccount(Map<String,Object> param);

    List<String> selectUserRole(Map<String, Object> param);

    List<String> selectUserPermission(Map<String, Object> param);

}
