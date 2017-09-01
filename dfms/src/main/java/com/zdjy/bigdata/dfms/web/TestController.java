package com.zdjy.bigdata.dfms.web;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import javax.servlet.http.HttpSession;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zdjy.bigdata.dfms.entity.User;

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
        User user=(User) session.getAttribute("user");
        try {
            uploadFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        FileSystem fileSystem;
		try {
			fileSystem = connect();
//			fileSystem = FileSystem.get(new URI("hdfs://centos201:9000"), new Configuration(), user.getName());
			// 上传，从本地文件系统传到hdfs系统
			fileSystem.copyFromLocalFile(new Path("D:\\Documents\\我的文档\\GitHub\\dfms\\dfms\\src\\main\\webapp\\upload\\"+filename), new Path("/"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        //重定向
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
	
	@RequestMapping("down")
    public ModelAndView downFile(String down_name,HttpSession session) throws Exception{
		FileSystem fileSystem=connect();
		Path down_path=new Path("D:\\Documents\\我的文档\\GitHub\\dfms\\dfms\\src\\main\\webapp\\upload\\"+down_name);
        FileStatus[] listStatus = fileSystem.listStatus(new Path(down_name));
        Path path = null;
        for(FileStatus fileStatus:listStatus){
        	path=fileStatus.getPath();
        }
		try {
			fileSystem.copyToLocalFile(path, down_path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        //重定向
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
	
	@RequestMapping("delete")
	public String delete(String delete_name) throws Exception {
		FileSystem fileSystem = connect();
		//第二个参数代表递归删除,主要用在删除目录上
		String path="hdfs://wu11:9000"+delete_name;
		fileSystem.delete(new Path(path), true);
		//查看是否删除
		return "delete";
	}
	
	
	public FileSystem connect() throws Exception {
		FileSystem fileSystem = FileSystem.get(new URI("hdfs://wu11:9000"), new Configuration(), "centos");
		return fileSystem;
	}
}
