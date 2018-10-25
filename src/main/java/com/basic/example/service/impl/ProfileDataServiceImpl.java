package com.basic.example.service.impl;

import com.basic.example.dto.Profile;
import com.basic.example.repository.ProfileRepository;
import com.basic.example.service.api.ProfileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service("ProfileDataService")
public class ProfileDataServiceImpl implements ProfileDataService {

    @Autowired
    public ProfileRepository profileRepository;

    @Autowired
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ProfileDataServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveUserProfileDetails(Profile profile){
        profileRepository.save(profile);
    }


    @Override
    public long getprofileDataHighestID(){

        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "id"));
        query.limit(1);
        Profile profileObj=mongoTemplate.findOne(query, Profile.class);
        if (profileObj != null) {
            return profileObj.getId();
        }
        return 0;
    }
}
