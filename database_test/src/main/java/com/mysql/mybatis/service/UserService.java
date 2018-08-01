package com.mysql.mybatis.service;

import com.mysql.mybatis.dao.User;

/**
 * Created by test on 2017/4/6.
 */
public interface UserService {
    public User getUserById(int userId);
}
