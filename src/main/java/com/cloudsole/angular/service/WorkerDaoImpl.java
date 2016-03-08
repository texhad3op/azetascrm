package com.cloudsole.angular.service;

import org.springframework.stereotype.Repository;

import com.cloudsole.angular.model.Worker;

@Repository("workerDaoImpl")
public class WorkerDaoImpl extends AbstractService<Worker> implements WorkerDao {
	
	public WorkerDaoImpl() {
		super(Worker.class);
	}

}
