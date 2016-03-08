package com.cloudsole.angular.service;

import java.util.List;

import com.cloudsole.angular.model.Worker;

public interface WorkerDao {
	 Worker merge(Worker worker);

	 List<Worker> getAll();

	 void remove(long id);

}
