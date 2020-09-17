package com.byrc.byyc.service.impl;

import com.byrc.byyc.mapper.UserMapper;
import com.byrc.byyc.model.User;
import com.byrc.byyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        //return null;
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    @Override
    public void del(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
