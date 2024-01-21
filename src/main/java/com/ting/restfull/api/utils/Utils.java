package com.ting.restfull.api.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Utils {

    public String generateUUID(){
        return UUID.randomUUID().toString();
    }


}
