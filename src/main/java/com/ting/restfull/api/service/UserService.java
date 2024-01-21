package com.ting.restfull.api.service;

import com.ting.restfull.api.model.response.UserDetailsRequestModel;
import com.ting.restfull.api.model.response.UserRest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {


    public UserRest createUserRest(UserDetailsRequestModel userDetailsRequestModel){
        UserRest userRest = new UserRest(UUID.randomUUID().toString());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setEmail(userDetailsRequestModel.getEmail());
        System.out.println("createUserRest is triggered user: " + userRest);
        return userRest;
    }


}
