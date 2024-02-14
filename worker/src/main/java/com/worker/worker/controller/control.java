package com.worker.worker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.worker.worker.model.User;

@RestController
public class control {
	
	@GetMapping(value="/controller/test",produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<User> getUser(User user){
		RestTemplate resttemplate = new RestTemplate(); 
		String userurl="https://jsonplaceholder.typicode.com/posts/1/comments";
		ResponseEntity<User[]> response = resttemplate.getForEntity(userurl, User[].class);
		List<User> userlist=new LinkedList<User>();
		for(User u:userlist) {
			if(u.getId()==3) {
				System.out.println(u);
			}
		}
		
		return null;
		
	}
	
	

}
