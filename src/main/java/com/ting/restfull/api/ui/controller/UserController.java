package com.ting.restfull.api.ui.controller;

import com.ting.restfull.api.model.response.UserDetailPutModel;
import com.ting.restfull.api.model.response.UserDetailsRequestModel;
import com.ting.restfull.api.model.response.UserRest;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users = new HashMap<>();

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam(value = "limit") int limit, @RequestParam(value = "sort", required = false) String sort) {
        return "get users was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest user;
//        Following Code can trigger exception which userId is not exist
        user =  users.get(userId);
        user.getEmail();

        if (users.containsKey(userId)) {
            user = users.get(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest = new UserRest(UUID.randomUUID().toString());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setEmail(userDetailsRequestModel.getEmail());

        if (users == null) users = new HashMap<>();
        users.put(userRest.getUserId(), userRest);

        System.out.println(userRest);
        return new ResponseEntity<>(userRest, HttpStatus.OK);
    }

    @PutMapping(path = "{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> updateUser(@Valid @RequestBody UserDetailPutModel userDetailPutModel, @PathVariable String userId) {

        if (!users.containsKey(userId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserRest user = users.get(userId);
        if (userDetailPutModel.getFirstName() != null) user.setFirstName(userDetailPutModel.getFirstName());
        if (userDetailPutModel.getLastName() != null) user.setLastName(userDetailPutModel.getLastName());

        users.put(userId, user);

        System.out.println("User updated: " + user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<String> getUsers(@PathVariable String userId) {

        if(users.containsKey(userId)){
            users.remove(userId);
            return new ResponseEntity<>("Deleted " + userId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found: " + userId, HttpStatus.NOT_FOUND);
        }
    }


}
