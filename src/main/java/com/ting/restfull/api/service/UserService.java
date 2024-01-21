package com.ting.restfull.api.service;

import com.ting.restfull.api.model.response.UserDetailsRequestModel;
import com.ting.restfull.api.model.response.UserRest;
import com.ting.restfull.api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    Utils utils;

    @Autowired
    public UserService(Utils utils) {
        this.utils = utils;
    }


    public UserRest createUserRest(UserDetailsRequestModel userDetailsRequestModel){
        UserRest userRest = new UserRest(utils.generateUUID());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setEmail(userDetailsRequestModel.getEmail());
        System.out.println("createUserRest is triggered user: " + userRest);
        return userRest;
    }


}
