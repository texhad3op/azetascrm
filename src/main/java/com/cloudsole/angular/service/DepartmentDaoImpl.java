package com.cloudsole.angular.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsole.angular.model.Department;

//@Repository("departmentDaoImpl")
//public class DepartmentDaoImpl implements DepartmentDao {
//	@PersistenceContext
//	private EntityManager em;
//
//	@Transactional
//	public void mergeDepartment(Department department) {
//		em = em.getEntityManagerFactory().createEntityManager();
//		EntityTransaction t = em.getTransaction();
//		t.begin();
//		Department dep = em.merge(department);
//		t.commit();
//	}
//
//	@Transactional
//	public void deleteDepartment(long id) {
//		em = em.getEntityManagerFactory().createEntityManager();
//		EntityTransaction t = em.getTransaction();
//		t.begin();
//		Department department = em.find(Department.class, id);
//		em.remove(department);
//		t.commit();
//	}
//
//	public List<Department> getAll() {
//		return em.createQuery("from Department", Department.class).getResultList();
//	}
//}

@Repository("departmentDaoImpl")
public class DepartmentDaoImpl extends AbstractService<Department> implements DepartmentDao {

}
