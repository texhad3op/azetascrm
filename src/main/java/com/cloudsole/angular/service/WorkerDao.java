package com.cloudsole.angular.service;

import java.util.List;

import com.cloudsole.angular.model.Worker;

public interface WorkerDao {
	public void mergeWorker(Worker worker);

	public List<Worker> getAll();

	public void deleteWorker(long id);
}
