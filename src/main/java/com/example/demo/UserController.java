package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    // get users REST
    @GetMapping("/users")
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    //get user by id REST
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
        throws ResourceNotFoundException {
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User record not found for this id :: " + userId));
            return ResponseEntity.ok().body(user);
    }

    // save user REST
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return this.userRepository.save(user);
    }

    //update user REST
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException{

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User record not found for this id :: " + userId));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    //delete user REST
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException{

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User record not found for this id :: " + userId));

        this.userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);

        return response;

    }
}
