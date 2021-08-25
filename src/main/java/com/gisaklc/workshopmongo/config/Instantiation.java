package com.gisaklc.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gisaklc.workshopmongo.domain.Post;
import com.gisaklc.workshopmongo.domain.User;
import com.gisaklc.workshopmongo.dto.AuthorDto;
import com.gisaklc.workshopmongo.repository.PostRepository;
import com.gisaklc.workshopmongo.repository.UserRepository;

@Configuration // o spring entende q é uma configuração
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRespository;

	@Autowired
	private PostRepository postRespository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRespository.deleteAll();
		postRespository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		userRespository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo abraços!",
				new AuthorDto(maria));

		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

		postRespository.saveAll(Arrays.asList(post1, post2));

	}

}
