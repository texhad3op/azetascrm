package com.cloudsole.angular.service;

import java.util.List;

import com.cloudsole.angular.model.Department;
import com.cloudsole.angular.model.Worker;

public interface DepartmentDao {
	public void mergeDepartment(Department department);

	public List<Department> getAll();

	public void deleteDepartment(long id);

}
