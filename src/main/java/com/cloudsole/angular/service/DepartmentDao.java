package com.cloudsole.angular.service;

import java.util.List;

import com.cloudsole.angular.model.Department;

public interface DepartmentDao {
	public void createDepartment(Department department);

	public List<Department> getAll();
	public void deleteDepartment(long id);
	 void updateDepartment(Department department);
}
