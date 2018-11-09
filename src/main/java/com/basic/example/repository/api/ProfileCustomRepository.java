package com.basic.example.repository.api;

import com.basic.example.dto.Profile;

public interface ProfileCustomRepository {

    void saveEmployeeProfileDetails(Profile profile);

    Profile getEmployeeProfileDetails(long id);

    void updateEmployeeProfileDetails(Profile profile);

    void removeEmployeeProfileDetails(long eid);

    long getEmployeeHighestID();

    void clearCache() ;
}
