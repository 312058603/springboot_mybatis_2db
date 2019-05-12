package com.wpx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 目录树数据测试
 */
@RestController
@RequestMapping("/TreeController")
public class TreeConreoller {
    @RequestMapping(method = RequestMethod.POST, value = "/getTreeData")
    private List<Map<String,Object>> getTreeData(int superId) {
        List<Map<String,Object>> response=new ArrayList<>();
        Map<String,Object> item1=new HashMap<>();
        item1.put("id","20001");
        item1.put("checked","false");
        item1.put("text","内容20001");
        item1.put("leaf","true");
        response.add(item1);
        Map<String,Object> item2=new HashMap<>();
        item2.put("id","20002");
        item1.put("checked","false");
        item2.put("text","内容20002");
        item2.put("leaf","true");
        response.add(item2);
        return response;
    }

}
