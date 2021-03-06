package com.basic.example.service.api;

import com.basic.example.dto.Profile;

import java.util.List;

public interface ProfileDataService {

    void saveEmployeeProfileDetails(Profile profile);

    void updateEmployeeProfileDetails(Profile profile);

    void removeEmployeeProfileDetails(long eid);

    Profile getEmployeeProfileDetails(long id);

    long getEmployeeHighestID();

}
