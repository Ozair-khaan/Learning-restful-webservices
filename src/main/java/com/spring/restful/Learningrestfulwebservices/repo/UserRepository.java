package com.spring.restful.Learningrestfulwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restful.Learningrestfulwebservices.bean.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
