package com.basic.example.service.impl;

import com.basic.example.dto.Profile;
import com.basic.example.repository.api.ProfileCustomRepository;
import com.basic.example.service.api.ProfileDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service("ProfileDataService")
public class ProfileDataServiceImpl implements ProfileDataService {

    private static Logger logger = LoggerFactory.getLogger(ProfileDataServiceImpl.class);

    @Autowired
    public ProfileCustomRepository profileCustomRepository;


    @Override
    public void saveEmployeeProfileDetails(Profile profile){
        profileCustomRepository.saveEmployeeProfileDetails(profile);
    }
    @Override
    public Profile getEmployeeProfileDetails(long id){
       Profile employeeProfileInfo= profileCustomRepository.getEmployeeProfileDetails(id);
        return employeeProfileInfo;
    }

    @Override
    public void updateEmployeeProfileDetails(Profile profile){
        profileCustomRepository.updateEmployeeProfileDetails(profile);
    }

    @Override
    public void removeEmployeeProfileDetails(long eid){
        profileCustomRepository.removeEmployeeProfileDetails(eid);
    }

    @Override
    public long getEmployeeHighestID(){
        long empId=profileCustomRepository.getEmployeeHighestID();
        if (empId != 0) {
            return empId;
        }
        return 0;
    }

}
