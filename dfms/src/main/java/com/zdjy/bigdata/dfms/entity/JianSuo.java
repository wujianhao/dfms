package com.zdjy.bigdata.dfms.entity;

import org.apache.hadoop.fs.Path;

public class JianSuo {
	private String time;
	private Long len;
	private String user;
	private String leixing;
	private Path pwd;
	private String name;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Long getLen() {
		return len;
	}
	public void setLen(Long len) {
		this.len = len;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public Path getPwd() {
		return pwd;
	}
	public void setPwd(Path path) {
		this.pwd = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
