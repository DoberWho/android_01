package com.ctbarbanza.gupyou.models;

import android.os.Parcelable;

import java.io.Serializable;

public class Persona implements Serializable {

    private Long id;
    private String name;
    private String lastName;

    private String image = "https://i.imgur.com/iYnIUss.jpeg";

    private String gmail;
    private String faceook;
    private String github;

    public Persona(int idx) {
        this.id = Long.valueOf(idx);
        this.name = "Persona "+idx;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getFaceook() {
        return faceook;
    }

    public void setFaceook(String faceook) {
        this.faceook = faceook;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
