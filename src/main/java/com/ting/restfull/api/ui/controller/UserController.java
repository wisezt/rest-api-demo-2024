package com.ting.restfull.api.ui.controller;

import com.ting.restfull.api.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUsers(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "limit") int limit,
            @RequestParam(value = "sort", required = false) String sort) {
        return "get users was called with page = " + page + " and limit = " + limit;
    }


//    @GetMapping(path = "{userId}"
//            ,produces = {
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_JSON_VALUE
//            })
//    )
//    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
//        System.out.println("Recieved userId: " + userId);
//        UserRest user = new UserRest(userId);
//        user.setEmail("user" + userId + "@test.com");
//        user.setFirstName("fristName" + userId);
//        user.setLastName("lastName" + userId);
//        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
//    }

    @GetMapping(path = "{userId}"
            ,produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
//    )
    public UserRest getUser(@PathVariable String userId) {

        System.out.println("Recieved userId: " + userId);
        UserRest user = new UserRest(userId);
        user.setEmail("user" + userId + "@test.com");
        user.setFirstName("fristName" + userId);
        user.setLastName("lastName" + userId);
//        List<UserRest> list = new ArrayList<>();
//        list.add(user);

        return user;
    }

    @PostMapping
    public String createUser(String userId) {
        return "Create user";
    }

    @PutMapping
    public String updateUser() {
        return "Update user";
    }

    @DeleteMapping
    public String getUsers() {
        return "Delete User";
    }


}
