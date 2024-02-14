package com.worker.worker.service;




import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.worker.worker.model.Worker;

@Service
public interface WorkerService {
  
	ResponseEntity<?> saveWorker(Worker worker);
	ResponseEntity<?> getAllWorkers();
	ResponseEntity<?> getWokerById(int id);
	ResponseEntity<?> updateWorker(Worker worker,int id);
	ResponseEntity<?> deleteWorker(int id);

}
