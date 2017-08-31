package com.zdjy.bigdata.dfms.web;

import java.io.File;
import java.net.URI;


import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping("/{page}")
	public String shen(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("upload")
    public ModelAndView uploadFile(MultipartFile uploadFile,HttpSession session) throws Exception{
        //获取上传文件名
        String filename = uploadFile.getOriginalFilename();
        //获取WebRoot下的upload文件夹的绝对路径作为前半部分路径
        String leftPath = session.getServletContext().getRealPath("/upload");
        
        //将文件的前半部分路径与文件名拼接
        File file = new File(leftPath, filename);
       
		// 查看是否上传
		/*printPath(fileSystem, new Path("/"));*/
        
        try {
            uploadFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        FileSystem fileSystem;
		try {
			fileSystem = FileSystem.get(new URI("hdfs://centos201:9000"), new Configuration(), "centos");
			// 上传，从本地文件系统传到hdfs系统
			fileSystem.copyFromLocalFile(new Path("D:\\用户目录\\我的文档\\GitHub\\dfms\\dfms\\src\\main\\webapp\\upload\\"+filename), new Path("/"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        //重定向
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
