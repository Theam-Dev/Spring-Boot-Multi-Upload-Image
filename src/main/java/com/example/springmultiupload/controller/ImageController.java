package com.example.springmultiupload.controller;

import com.example.springmultiupload.model.Post;
import com.example.springmultiupload.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class ImageController {
    @Autowired
    private ImageService postService;
    public static String uploadDirectory = "src/main/resources/static/upload";


    @GetMapping("/")
    public String Create(Model model) {
        Post post = new Post();
        model.addAttribute("post",post);
        return "form";
    }
    @PostMapping("/save")
    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Post post) {
        try {

            List<Post> fileList = new ArrayList<Post>();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime sedateness = LocalDateTime.now();
            String date = dtf.format(sedateness);

            for (MultipartFile file : files) {
                String filename = date+file.getOriginalFilename();
                Path filePath = Paths.get(uploadDirectory,filename);
                String title = post.getTitle();

                Post fileModal = new Post(title, filePath.toString());
                fileList.add(fileModal);
                Files.write(filePath,file.getBytes());
            }
            postService.saveData(fileList);
            } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return "redirect:/";
    }
}
