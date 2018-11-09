package com.basic.example.config;

import com.basic.example.SpringBootApp;
import com.basic.example.repository.api.ProfileCustomRepository;
import com.basic.example.service.api.ProfileDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheConfig {

    private static Logger logger = LoggerFactory.getLogger(SpringBootApp.class);

    private final String CACHE_CLEAR_CRON = "0 0/1 * * * ?";
//0/30 0/1 * 1/1 * ? * cron expression to run for every 30 seconds
    @Autowired
    private ProfileCustomRepository profileCustomRepository;

    @Scheduled(cron = CACHE_CLEAR_CRON)
    public void scheduleCron() {
        logger.debug("Employee Management Cache Removed by Cron Trigger");
        profileCustomRepository.clearCache();
    }
}
