package com.zdjy.bigdata.dfms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdjy.bigdata.dfms.dao.DepartmentMapper;
@Service
public class DepartmentServiceimpl implements DepartmentService {
@Autowired
private DepartmentMapper departmentmapper;
	@Override
	public List selectALL() {
		// TODO Auto-generated method stub
		return departmentmapper.selectALL();
	}

}
