package com.cloudsole.angular.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudsole.angular.model.Worker;
import com.cloudsole.angular.service.WorkerDao;

@Controller
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	WorkerDao workerDao;

	@RequestMapping(value = "/all.json", method = RequestMethod.GET)
	public @ResponseBody List<Worker> viewAllWorkers() {
		return workerDao.getAll();
	}


	@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody void addOrder(@RequestBody String json) {
		System.out.println();
	    ObjectMapper mapper = new ObjectMapper();

	    try {

	    	Worker worker = mapper.readValue(json, Worker.class);
			System.out.println();
			workerDao.merge(worker);

	    } catch (JsonGenerationException e) {

	        e.printStackTrace();

	    } catch (JsonMappingException e) {

	        e.printStackTrace();

	    } catch (IOException e) {

	        e.printStackTrace();

	    }

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteWorker(@PathVariable("id") String id) {
		workerDao.remove(Long.valueOf(id));
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public @ResponseBody void updateAddressBook(@RequestBody Worker worker) {
		workerDao.merge(worker);
	}

	@RequestMapping("/layout")
	public String getTodoPartialPage() {
		return "worker/layout";
	}
}
