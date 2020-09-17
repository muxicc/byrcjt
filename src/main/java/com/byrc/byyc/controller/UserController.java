package com.byrc.byyc.controller;

import com.alibaba.fastjson.JSONObject;
import com.byrc.byyc.model.User;
import com.byrc.byyc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("findAll")
    @ResponseBody
    List<User> user(@RequestBody String strJson) {
        System.out.println("=============================================");
        List<User> userList = null;
        userList = userService.queryUser();
        return userList;
    }

    @RequestMapping("del")
    public @ResponseBody
    String del(@RequestBody String strJson) {
        String info = "删除员工信息成功!";
        JSONObject jsonObject = JSONObject.parseObject(strJson);
        try {
            System.out.println(jsonObject.getInteger("id"));
            userService.del(jsonObject.getInteger("id"));
        } catch (Exception e) {
            e.printStackTrace();
            info = "删除员工信息失败!";
        }
        return info;
    }

    @RequestMapping("add")
    public @ResponseBody
    String add(@RequestBody User user) {
        String info = "添加员工信息成功!";
        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            info = "添加员工信息失败!";
        }
        return info;
    }
}
