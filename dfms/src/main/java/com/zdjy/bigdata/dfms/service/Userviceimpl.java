package com.zdjy.bigdata.dfms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdjy.bigdata.dfms.dao.UserMapper;
import com.zdjy.bigdata.dfms.entity.User;
import com.zdjy.bigdata.dfms.entity.UserExample;
@Service
public class Userviceimpl implements UserService {
@Autowired
private UserMapper usermapper;
	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(id);
	}
	@Override
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return usermapper.selectByExample(example);
	}
	@Override
	public User selectByName(String name) {
		// TODO Auto-generated method stub
		return usermapper.selectByName(name);
	}

}
