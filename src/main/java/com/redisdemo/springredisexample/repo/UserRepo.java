package com.redisdemo.springredisexample.repo;

import java.util.Map;

import com.redisdemo.springredisexample.modal.User;

public interface UserRepo {

	void save(User user);

	Map<String, User> findAll();

	void update(User user);

	void delete(String Id);

	User findbyId(String id);

}
