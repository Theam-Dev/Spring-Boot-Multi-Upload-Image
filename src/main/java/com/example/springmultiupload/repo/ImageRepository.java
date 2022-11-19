package com.example.springmultiupload.repo;


import com.example.springmultiupload.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Post,Integer> {
}