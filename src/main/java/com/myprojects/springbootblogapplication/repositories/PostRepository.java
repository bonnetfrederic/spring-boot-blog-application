package com.myprojects.springbootblogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myprojects.springbootblogapplication.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
