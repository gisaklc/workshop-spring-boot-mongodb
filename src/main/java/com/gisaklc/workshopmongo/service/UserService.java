package com.gisaklc.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gisaklc.workshopmongo.domain.User;
import com.gisaklc.workshopmongo.dto.UserDto;
import com.gisaklc.workshopmongo.repository.UserRepository;
import com.gisaklc.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	// injeção de depencia automatica do spring , insntancia o objeto
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();

	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public User insert(User obj) {
		return userRepository.insert(obj);

	}

	public void delete(String id) {
		findById(id);//busca o objeto e dar erro se nao encontrar
		userRepository.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		//newObj = new User(obj.getNome(), obj.getEmail());
		return userRepository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	
	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}

}
