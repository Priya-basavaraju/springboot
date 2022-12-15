package com.tns.b27module;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class AdminController {
	
	@Autowired
	private AdminService service;
	
	//Retrieval
	@GetMapping("/admins")
	public List<Admin> list()
	{
		return service.listAll();
	}
	
	//Retrieve By Id
	public ResponseEntity <Admin> get(@PathVariable Integer id){
		try {
			Admin admin = service.get(id);
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	            }

	//create
	@PostMapping("/admin")
	public void add(@RequestBody Admin admin) {
		service.save(admin);
	}
	
	//Update
	@PutMapping("/admin/{id}")
	public ResponseEntity <?> update(@RequestBody Admin admin,@PathVariable Integer id){
		try {
			Admin existAdmin = service.get(id);
			service.save(admin);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity <> (HttpStatus.NOT_FOUND);
			
		}
	}
	//delete
	@DeleteMapping("/admin/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}	
	

}
