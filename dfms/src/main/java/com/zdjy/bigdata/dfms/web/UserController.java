package com.zdjy.bigdata.dfms.web;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.api.Session;
import com.zdjy.bigdata.dfms.entity.User;
import com.zdjy.bigdata.dfms.service.DepartmentService;
import com.zdjy.bigdata.dfms.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
    @Autowired
    private DepartmentService departmentservice;
	
    Connection Con = new Connection();
	
	@RequestMapping("index")
	public String findByname(String name,HttpSession session,HttpServletRequest request) throws Exception{
		User user = userService.selectByName(name);
		List deList = departmentservice.selectALL();
		if(user!=null){
		session.setAttribute("user", user);
		session.setAttribute("dpList", deList);
		FileSystem fileSystem = Con.connect();
		}
		return "index";
				
	}
	
	@RequestMapping("exit")
	public String exit(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("dpList");
		return "login";
	}
}
