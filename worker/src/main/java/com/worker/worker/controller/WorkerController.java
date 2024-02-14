package com.worker.worker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.worker.worker.model.User;
import com.worker.worker.model.Users;
import com.worker.worker.model.Worker;
import com.worker.worker.service.WorkerService;


@RestController

@RequestMapping("/api/workers")
public class WorkerController {
	@Autowired
	 WorkerService workerservice;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveWorker(@RequestBody Worker worker){
		 
				 ResponseEntity<?> responseworker =workerservice.saveWorker(worker);
				return responseworker;
	}
	
	@GetMapping(value="/worker",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getAllWorkers(){
		RestTemplate restTemplate = new RestTemplate();
		String userUrl
		  = "https://jsonplaceholder.typicode.com/posts/1/comments";
	
		
		ResponseEntity<User[]> response
		  = restTemplate.getForEntity(userUrl, User[].class);
		//Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
         List<User> userslist = Arrays.asList(response.getBody());
      boolean Id=false;
      
         for( User u :userslist) {
        	if(u.getId()==3) {
        	
        		Id=true;
             	System.out.println(u);

        		break;
         	}
        	
         }
         if(Id ==true) {
        	
			System.out.println("your required id is present in the list");
			
         }
         else {
        	 System.out.println("your required id is not present in the list");
        	
         }
         
        
        	
        	
         
//		ResponseEntity<?> responseworker = workerservice.getAllWorkers();
		//System.out.println("response"+response.getBody());
		return null;
		
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getWorkerById(@PathVariable( "id") int id) {
		ResponseEntity<?> responseworker=workerservice.getWokerById(id);
		
		return responseworker;
	}
	@PutMapping("{id}")
	public ResponseEntity<?> updateWoker( @RequestBody Worker worker,@PathVariable ("id") int id){
		ResponseEntity<?> responseworker=workerservice.updateWorker(worker, id);
		return responseworker;
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteWorker(@PathVariable ("id") int id){
		
		ResponseEntity<?> responseworker = workerservice.deleteWorker(id);
		return responseworker;
		
	}

}
