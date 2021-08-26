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
import com.gisaklc.workshopmongo.dto.CommentDto;
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

	
		CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
		CommentDto c2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(bob));
		CommentDto c3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRespository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRespository.save(maria);
		
		
		

	}

}
