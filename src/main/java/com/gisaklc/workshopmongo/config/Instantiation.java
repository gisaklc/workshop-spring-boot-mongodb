package com.gisaklc.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gisaklc.workshopmongo.domain.User;
import com.gisaklc.workshopmongo.repository.UserRepository;

@Configuration // o spring entende q é uma configuração
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRespository;

	@Override
	public void run(String... args) throws Exception {
		userRespository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRespository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
