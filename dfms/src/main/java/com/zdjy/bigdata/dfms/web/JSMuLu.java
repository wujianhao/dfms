package com.zdjy.bigdata.dfms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import java.io.File;
import java.net.URI;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsPermission;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdjy.bigdata.dfms.entity.JianSuo;


@Controller
@RequestMapping("/ml/")
public class JSMuLu {
	Connection con=new Connection();		
	@RequestMapping("/muluload")
	public String  jsml(HttpServletRequest request) throws Exception {
		FileSystem fileSystem = con.connect();
		FileStatus[] listatus = fileSystem.listStatus(new Path("/centos/hadoop/test/out"));
		
		List list=new ArrayList();
		
		JianSuo jSuo=new JianSuo();
		for (FileStatus fileStatus : listatus) {
			//System.out.println(fileStatus.getPath());
			if (fileStatus.isDirectory()) {
				//jsml(fileSystem, fileStatus.getPath());
				String url=fileStatus.getPath().toString();
				String [] names=url.split("/");
				String name=null;
					name=names[names.length-1];
				
				//文件名
				jSuo.setName(name);
				
				//大小
				jSuo.setLen(fileStatus.getLen());
				//时间
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM-dd HH:mm");
				Long time= new Long(fileStatus.getModificationTime());
				Date date=new Date();
				String dd=simpleDateFormat.format(time);
				jSuo.setTime(dd);
				//用户
				jSuo.setUser(fileStatus.getOwner());
				//路径
				jSuo.setPwd(fileStatus.getPath());
				
				list.add(jSuo);
				
				request.setAttribute("list",list);
				
			    }   
			}
		return "mulu";
	}

	 }
