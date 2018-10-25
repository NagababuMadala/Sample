package com.basic.example.service.api;

import com.basic.example.dto.Profile;

import java.util.List;

public interface ProfileDataService {

    void saveUserProfileDetails(Profile profile);

    long getprofileDataHighestID();
}
