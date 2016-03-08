package com.cloudsole.angular.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<E> {
	@PersistenceContext
	private EntityManager em;

	protected Class<E> clazz;

	public AbstractService(Class<E> clazz) {
		this.clazz = clazz;
	}

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
	public void remove(long id) {
		em = em.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		E entity = em.find(clazz, id);
		em.remove(entity);
		t.commit();
	}

	public List<E> getAll() {
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
	}

	public E find(long id) {
		return em.find(clazz, id);
	}
}
