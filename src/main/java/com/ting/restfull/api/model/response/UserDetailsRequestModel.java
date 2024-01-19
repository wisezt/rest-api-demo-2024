package com.ting.restfull.api.model.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message="First Name cannot be null")
    private String firstName;
    @NotNull(message="Last Name cannot be null")
    private String lastName;
    @NotNull(message="Password cannot be null")
    @Size(min=8, max=16, message = "Password must be between 8 to 16 characters")
    private String password;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
