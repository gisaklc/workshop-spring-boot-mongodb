package com.gisaklc.workshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gisaklc.workshopmongo.domain.Post;
import com.gisaklc.workshopmongo.repository.PostRepository;
import com.gisaklc.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public List<Post> findAll() {
		return postRepository.findAll();

	}

	public List<Post> findByTitle(String text) {
		return postRepository.searchTitle(text);
		// return postRepository.findByTitleContainingIgnoreCase(text);
	}

	public List<Post> fullSearch(String text, Date min, Date max) {
		//acrescentar + um dia na data maxima pq a data
		//é armazena em millisegundos tem hora, minuto e segundo
		max = new Date(max.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, min, max);

	}

}
