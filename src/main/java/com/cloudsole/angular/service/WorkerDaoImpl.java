package com.cloudsole.angular.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsole.angular.model.Department;
import com.cloudsole.angular.model.Worker;

@Repository("workerDaoImpl")
public class WorkerDaoImpl implements WorkerDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void mergeWorker(Worker worker) {
	    em = em.getEntityManagerFactory().createEntityManager();
	    EntityTransaction t = em.getTransaction();
	    t.begin();
	    Department deps = em.find(Department.class, worker.getDepartment().getId());
//	    Department department = new Department();
//	    department.setId(1);
	    
	    //worker.setDepartment(department);
	    worker.setDepartment(deps);
	    Worker w = em.merge(worker);
	    t.commit();
	}

	@Transactional
	public void deleteWorker(long id){
	    em = em.getEntityManagerFactory().createEntityManager();
	    EntityTransaction t = em.getTransaction();
	    t.begin();
	    Worker worker = em.find(Worker.class, id);
		em.remove(worker);
	    t.commit();
	}
	
	public List<Worker> getAll() {
		return em.createQuery("from Worker", Worker.class).getResultList();
	}
}
