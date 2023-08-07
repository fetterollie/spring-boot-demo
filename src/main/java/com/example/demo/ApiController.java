package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// annotation
@RestController
@RequestMapping("/api")
// class
public class ApiController {

    Api api;

    @GetMapping("{id}")
    public ResponseEntity<Api> api(String id) {
        return new ResponseEntity<Api>(api, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createApiDetails(@RequestBody Api api) {
        this.api = api;

        return new ResponseEntity<String> (
            String.format(
            "Api Details Created Successfully. \nid: %s \ncontent: %s",
            api.getId(), 
            api.getContent()), 
            HttpStatus.CREATED   
        );

    }
}

// WITHOUT ResponseEntity
//     @PostMapping
//     public String createApiDetails(@RequestBody Api api) {
//         this.api = api;

//         return String.format(
//             "Api Details Created Successfully. \nid: %s \ncontent: %s",
//             api.getId(), 
//             api.getContent()
//         );

//     }
// }
