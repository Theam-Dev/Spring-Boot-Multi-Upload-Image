package com.example.springmultiupload.service;

import com.example.springmultiupload.model.Post;

import java.util.List;

public interface ImageService {
    List<Post> saveData(List<Post> fileList);
}
