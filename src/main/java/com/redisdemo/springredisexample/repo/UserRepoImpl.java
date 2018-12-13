package com.redisdemo.springredisexample.repo;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redisdemo.springredisexample.modal.User;

@Repository
public class UserRepoImpl implements UserRepo {

	private RedisTemplate<String, User> redisTemplate;

	private HashOperations<String, String, User> hashOperations;

	public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("USER");
	} 	

	@Override
	public void update(User user) {
		save(user);
	}

	@Override
	public void delete(String Id) {
		hashOperations.delete("USER", Id);
	}

	@Override
	public User findbyId(String Id) {
		return hashOperations.get("USER", Id);
	}

}
