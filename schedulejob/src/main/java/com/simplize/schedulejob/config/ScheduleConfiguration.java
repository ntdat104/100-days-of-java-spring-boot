package com.simplize.schedulejob.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    Logger logger = LoggerFactory.getLogger(ScheduleConfiguration.class);

    @Scheduled(fixedRate = 1000)
    public void job() {
        logger.info("Job run every 1s: {}", new Date());
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void job2() {
        logger.info("Job2 run every 5s: {}", new Date());
    }

}
