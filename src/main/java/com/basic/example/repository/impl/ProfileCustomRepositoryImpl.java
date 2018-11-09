package com.basic.example.repository.impl;

import com.basic.example.dto.Profile;
import com.basic.example.repository.api.ProfileCustomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import static com.basic.example.util.EmployeeConstants.*;

@Repository
public  class ProfileCustomRepositoryImpl implements ProfileCustomRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    private static Logger logger = LoggerFactory.getLogger(ProfileCustomRepositoryImpl.class);

    @Cacheable(value = "employee")
    public void saveEmployeeProfileDetails(Profile profile){
        mongoTemplate.insert(profile);
    }
    @Cacheable(value = "employee")
    public Profile getEmployeeProfileDetails(long id){
        Profile employeeProfileDetails = mongoTemplate.findOne(new Query(Criteria.where(ID).is(id)), Profile.class);
    return employeeProfileDetails;
    }

    @Cacheable(value = "employee")
    public void updateEmployeeProfileDetails(Profile profile){
        mongoTemplate.save(profile);
    }

    @Cacheable(value = "employee")
    public void removeEmployeeProfileDetails(long eid){
        mongoTemplate.remove(new Query(Criteria.where(ID).is(eid)), Profile.class);
    }

    @Cacheable(value = "employee")
    public long getEmployeeHighestID(){

        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "id"));
        query.limit(1);
        Profile profileObj=mongoTemplate.findOne(query, Profile.class);
        if (profileObj != null) {
            return profileObj.getId();
        }
        return 0;
    }

    @CacheEvict(value = "employee", allEntries = true)
    public void clearCache() {
        logger.debug("Cache (emplyoees) Cleared");
    }
}
