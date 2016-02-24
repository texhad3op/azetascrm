package com.cloudsole.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudsole.angular.model.AddressBook;
import com.cloudsole.angular.model.Department;
import com.cloudsole.angular.service.DepartmentDao;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentDao departmentDao;

	@RequestMapping(value = "/all.json", method = RequestMethod.GET)
	public @ResponseBody List<Department> viewAllDepartment() {
		return departmentDao.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody void addAddressBookEntry(@RequestBody Department department) {
		departmentDao.mergeDepartment(department);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAddressBookEntry(@PathVariable("id") String id) {
		departmentDao.deleteDepartment(Long.valueOf(id));
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody void updateAddressBook(@RequestBody Department department) {
		departmentDao.mergeDepartment(department);
	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return "department/layout";
	}
}
