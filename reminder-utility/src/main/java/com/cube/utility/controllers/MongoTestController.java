package com.cube.utility.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cube.utility.processors.CubeUMDataProcessor;
import com.cube.utility.processors.MongoUserProcessor;

@RestController
public class MongoTestController {

	@Autowired
	private MongoUserProcessor mongoConfig;
	@Autowired
	private   Jongo mongoClient;
	@Autowired
	private   CubeUMDataProcessor cubeUMDataProcessor;

	@RequestMapping("test")
	public String test() throws Exception {

		try {

			ExecutorService executor = Executors.newFixedThreadPool(450);
			for (int i = 0; i < 450; i++) {
				Runnable worker = new MongoUserProcessor(mongoClient,cubeUMDataProcessor,i);
				executor.execute(worker);
			}
			executor.shutdown();
			while (!executor.isTerminated()) {
			}
			System.out.println("Finished all threads");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "completed";
	}
}
