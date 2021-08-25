package com.gisaklc.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gisaklc.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User laura = new User(null, "Laura Dias", "laura@hotmail.com");
		User fred = new User(null, "Fred Dias", "fred@hotmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(laura, fred));
		return ResponseEntity.ok().body(list);
	}

}
