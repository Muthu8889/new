package com.redisdemo.springredisexample.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redisdemo.springredisexample.modal.User;
import com.redisdemo.springredisexample.repo.UserRepo;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
	
	private UserRepo userRepo;

	public UserResource(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@GetMapping("/add/{id}/{name}")
	public User add(@PathVariable("id") final String id,
					@PathVariable("name") final String name) {
		userRepo.save(new User(id, name, 20000L));
		return userRepo.findbyId(id);
	}
	
	@GetMapping("/add/{id}/{name}")
	public User update(@PathVariable("id") final String id,
					@PathVariable("name") final String name) {
		userRepo.update(new User(id, name, 1000L));
		return userRepo.findbyId(id);
	}
	
	@GetMapping("/add/{id}/{name}")
	public Map<String, User> findAll(@PathVariable("id") final String id,
					@PathVariable("name") final String name) {
		return userRepo.findAll();
	}
	
}
