package com.gisaklc.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gisaklc.workshopmongo.domain.Post;
import com.gisaklc.workshopmongo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll() {
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
	}

}
