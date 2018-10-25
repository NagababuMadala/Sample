/*******************************************************************************
 * Copyright (c) 2018 macys.com. All rights reserved.
 *******************************************************************************/

package com.basic.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@ApiModel
@Document(collection = "ProfileInfo")
public class Profile implements Serializable {

    private static final long serialVersionUID = 11L;

    @Id
    @ApiModelProperty(notes = "The database generated user ID")
    private long id;
    @ApiModelProperty(notes = "The firstname of user ID")
    private String firstName;
    @ApiModelProperty(notes = "The lastname of product ID")
    private String lastName;
    @ApiModelProperty(notes = "The email of user")
    private String email;
    @ApiModelProperty(notes = "The phone number of user")
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "uid=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
