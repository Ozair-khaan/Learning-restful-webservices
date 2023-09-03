package com.spring.restful.Learningrestfulwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restful.Learningrestfulwebservices.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
