package com.spring.restful.Learningrestfulwebservices.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.Learningrestfulwebservices.bean.Name;
import com.spring.restful.Learningrestfulwebservices.bean.PersonV1;
import com.spring.restful.Learningrestfulwebservices.bean.PersonV2;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
