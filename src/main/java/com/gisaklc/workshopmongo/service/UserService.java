package com.gisaklc.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gisaklc.workshopmongo.domain.User;
import com.gisaklc.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	// injeção de depencia automatica do spring , insntancia o objeto
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();

	}

}
