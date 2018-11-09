/*******************************************************************************
 * Copyright (c) 2018 macys.com. All rights reserved.
 *******************************************************************************/

package com.basic.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@ApiModel
@Document(collection = "ProfileInfo")
@Data
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
}
