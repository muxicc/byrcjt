package com.byrc.byyc.service;


import com.byrc.byyc.model.User;

import java.util.List;

public interface UserService {

    public List<User> queryUser();

    public void del(int id);

    public void add(User user);
}
