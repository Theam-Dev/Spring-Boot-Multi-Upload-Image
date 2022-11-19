package com.example.springmultiupload.model;


import javax.persistence.*;

@Entity
@Table(name="Post")
public class Post{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(name="title")
    public String title;
    @Column(name="image")
    public String image;

    public Post(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
