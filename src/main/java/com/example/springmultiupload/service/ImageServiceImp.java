package com.example.springmultiupload.service;

import com.example.springmultiupload.model.Post;
import com.example.springmultiupload.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    private ImageRepository repo;

    @Override
    public List<Post> saveData(List<Post> post) {
        // Save all the files into database
        for (Post fileModal : post)
            repo.save(fileModal);

        return post;
    }

}
