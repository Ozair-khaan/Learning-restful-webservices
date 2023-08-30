package com.spring.restful.Learningrestfulwebservices.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.restful.Learningrestfulwebservices.ExceptionHandler.UserNotFoundException;
import com.spring.restful.Learningrestfulwebservices.bean.User;
import com.spring.restful.Learningrestfulwebservices.dao.UserDaoService;

@RestController
public class UserResourceController {

	private UserDaoService daoService;

	public UserResourceController(UserDaoService daoService) {
		this.daoService = daoService;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return daoService.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUsers(@PathVariable int id) {
		User user = daoService.findOne(id);

		if (user == null)
			throw new UserNotFoundException("Id: " + id);

		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = daoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		;
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		daoService.deleteById(id);
	}

}
