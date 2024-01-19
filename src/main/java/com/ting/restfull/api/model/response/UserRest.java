package com.ting.restfull.api.model.response;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class UserRest {
    private String firstName;
    private String lastName;
    private String userId;
    private String email;

    public UserRest(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
