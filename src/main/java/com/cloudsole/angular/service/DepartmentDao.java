package com.cloudsole.angular.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import org.springframework.transaction.annotation.Transactional;

import com.cloudsole.angular.model.Department;
import com.cloudsole.angular.model.Worker;

public interface DepartmentDao {
	Department merge(Department department);

	void remove(long id, Class<Department> d);

	List<Department> getAll(Class<Department> d);

}
