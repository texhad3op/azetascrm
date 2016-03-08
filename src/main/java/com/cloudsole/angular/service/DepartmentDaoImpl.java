package com.cloudsole.angular.service;

import org.springframework.stereotype.Repository;

import com.cloudsole.angular.model.Department;

@Repository("departmentDaoImpl")
public class DepartmentDaoImpl extends AbstractService<Department>implements DepartmentDao {
	public DepartmentDaoImpl() {
		super(Department.class);
	}
}
