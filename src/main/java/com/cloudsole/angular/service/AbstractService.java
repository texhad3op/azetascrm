package com.cloudsole.angular.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.cloudsole.angular.model.Department;

public abstract class AbstractService<E> {
	@PersistenceContext
	private EntityManager em;
	Class<E> eee;

	@Transactional
	public E merge(E e) {
		em = em.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		E ret = em.merge(e);
		t.commit();
		return ret;
	}

	@Transactional
	public void remove(long id, Class<E> e) {
		em = em.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		E entity = em.find(e, id);
		em.remove(entity);
		t.commit();
	}

	public List<E> getAll(Class<E> e) {
		return em.createQuery("from " + e.getName(), e).getResultList();
	}
}
