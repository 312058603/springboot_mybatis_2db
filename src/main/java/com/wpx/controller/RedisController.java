//package com.wpx.controller;
//
//import com.wpx.util.redis.ConfigUtils;
//import com.wpx.util.redis.RedisUtils;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.*;
//
//
///**
// * 连接本地Redis配置
// */
//@RestController
//@RequestMapping("/RedisController")
//public class RedisController {
//
//    @Resource
//    private RedisUtils redisUtils;
//
//    /**
//     * Redis存储数据
//     *
//     * @return
//     */
//    @RequestMapping("/RedisSetString")
//    public Map<String, Object> RedisSetString(String key, String value) {
//        Map<String, Object> response = new HashMap<>();
//        boolean isSuccess = redisUtils.set(key, value);
//        if (isSuccess) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, "Redis存储String成功:key=" + key + ",value=" + value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis存储String失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis获取数据
//     *
//     * @return
//     */
//    @RequestMapping("/RedisGetString")
//    public Map<String, Object> RedisGetString(String key) {
//        Map<String, Object> response = new HashMap<>();
//        String value = (String) redisUtils.get(key);
//        if (value != null) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis获取String失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis存储Set<Object>
//     *
//     * @return
//     */
//    @RequestMapping("/RedisSetSet")
//    public Map<String, Object> RedisSetSet(String key, String value) {
//        Map<String, Object> response = new HashMap<>();
//        long count = redisUtils.sSet(key, value);
//        if (count > 0) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, "Redis存储Set成功:key=" + key + ",value=" + value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis存储Set失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis获取Set<Object>
//     *
//     * @return
//     */
//    @RequestMapping("/RedisGetSet")
//    public Map<String, Object> RedisGetSet(String key) {
//        Map<String, Object> response = new HashMap<>();
//        long count = redisUtils.sGetSetSize(key);
//        if (count > 0) {
//            Set<Object> value = redisUtils.sGet(key);
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis获取Set失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis存储Map<String,Object>
//     *
//     * @return
//     */
//    @RequestMapping("/RedisSetMap")
//    public Map<String, Object> RedisSetMap(String key, @RequestBody Map<String, Object> value) {
//        Map<String, Object> response = new HashMap<>();
//        boolean isSuccess = redisUtils.hmset(key, value);
//        if (isSuccess) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, "Redis存储Map成功:key=" + key + ",value=" + value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis存储Map失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis获取Map<String,Object>
//     *
//     * @return
//     */
//    @RequestMapping("/RedisGetMap")
//    public Map<String, Object> RedisGetMap(String key) {
//        Map<String, Object> response = new HashMap<>();
//        Map<Object, Object> value = redisUtils.hmget(key);
//        if (value.size() > 0) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis获取Map失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis存储List<Object>
//     *
//     * @return
//     */
//    @RequestMapping("/RedisSetList")
//    public Map<String, Object> RedisSetList(String key, String value) {
//        Map<String, Object> response = new HashMap<>();
//        boolean isSuccess = redisUtils.lSet(key, value);
//        if (isSuccess) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, "Redis存储List成功:key=" + key + ",value=" + value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis存储List失败:key=" + key);
//        }
//        return response;
//    }
//
//    /**
//     * Redis获取List<Object>
//     *
//     * @return
//     */
//    @RequestMapping("/RedisGetList")
//    public Map<String, Object> RedisGetList(String key) {
//        Map<String, Object> response = new HashMap<>();
//        List<Object> value = redisUtils.lGet(key, 0, -1);
//        if (value != null && value.size() > 0) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, value);
//        } else {
//            response.put(ConfigUtils.CODE, "400");
//            response.put(ConfigUtils.MESSAGE, "失败");
//            response.put(ConfigUtils.DATA, "Redis获取List失败:key=" + key);
//        }
//        return response;
//    }
//
//}
