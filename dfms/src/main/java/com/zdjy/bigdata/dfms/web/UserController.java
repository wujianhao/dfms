package com.zdjy.bigdata.dfms.web;

import java.net.URI;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdjy.bigdata.dfms.entity.User;
import com.zdjy.bigdata.dfms.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("index")
	public String findByname(String name,HttpSession session) throws Exception{
		User user = userService.selectByName(name);
		if(user!=null){
		session.setAttribute("user", user);
		
		FileSystem fileSystem = FileSystem.get(new URI("hdfs://centos201:9000"), new Configuration(), user.getName());
		}
		return "view/index.do";
				
	}
}
