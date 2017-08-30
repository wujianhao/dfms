package com.zdjy.bigdata.dfms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping("/{page}")
	public String shen(@PathVariable String page){
		return page;
	}
}
