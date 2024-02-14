package com.worker.worker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.worker.worker.model.ConstantMessage;
import com.worker.worker.model.Worker;
import com.worker.worker.repository.WorkerRepository;
import com.worker.worker.service.WorkerService;


@Service

public class WorkerServiceImpl implements WorkerService {

	@Autowired
	 WorkerRepository workerrepository;
	@Override
	public ResponseEntity<?> saveWorker(Worker worker) {
		Worker optionalworker= workerrepository.save(worker);
		return ResponseEntity.ok(worker);
	}
	@Override
	public ResponseEntity<?> getAllWorkers() {

		List<Worker> list=workerrepository.findAll();
		return ResponseEntity.ok(list);
	}
	@Override
	public ResponseEntity<?> getWokerById(int id) {

		Optional<Worker> optionalworker=workerrepository.findById(id);
			if(optionalworker.isPresent()) {
				System.out.println(id);
			}
			else {
				
                System.out.println("not present");
				
		
	}
			return  ResponseEntity.ok(optionalworker);
		
	  
	}
	@Override
	public ResponseEntity<?> updateWorker(Worker worker,int id) {
		Optional<?> optionalworker=workerrepository.findById(id);
	//	Worker existingworker=workerrepository.findById(id);
		if(optionalworker.isPresent()) {
			System.out.println(id);
			worker.setName(worker.getName());
			worker.setEmail(worker.getEmail());
			workerrepository.save(worker);

		}
		else {
			
            System.out.println("not present");
			
	
}
		return  ResponseEntity.ok(worker);
	}
	@Override
	public ResponseEntity<?> deleteWorker(int id) {
		Optional<?> optionalworker=workerrepository.findById(id);
		
			if(optionalworker.isPresent()) {
				System.out.println(id);
				workerrepository.deleteById(id);

			}
			else {
				
	            System.out.println("not present");
				
		
	}
			return  ResponseEntity.ok(optionalworker);
	}
}
