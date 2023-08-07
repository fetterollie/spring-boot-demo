package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Api {
    // properties
    @JsonProperty("id")
    private String id;
    @JsonProperty("content")
    private String content;

    // empty constructor
    public Api() {
    }

    // setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // getter methods
    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
