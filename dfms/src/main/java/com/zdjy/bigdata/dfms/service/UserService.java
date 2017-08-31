package com.zdjy.bigdata.dfms.service;

import java.util.List;

import com.zdjy.bigdata.dfms.entity.User;
import com.zdjy.bigdata.dfms.entity.UserExample;

public interface UserService {
    User selectByPrimaryKey(Integer id);
    List<User> selectByExample(UserExample example);
    User selectByName(String name);
}
