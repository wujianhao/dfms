package com.zdjy.bigdata.dfms.web;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public class Connection {

	public FileSystem connect() throws Exception {
		FileSystem fileSystem = FileSystem.get(new URI("hdfs://wu11:9000"), new Configuration(), "centos");
		return fileSystem;
	}
}
