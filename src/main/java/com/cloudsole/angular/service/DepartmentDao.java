package com.cloudsole.angular.service;

import java.util.List;

import com.cloudsole.angular.model.Department;

public interface DepartmentDao {
	Department merge(Department department);

	void remove(long id);

	List<Department> getAll();

}
