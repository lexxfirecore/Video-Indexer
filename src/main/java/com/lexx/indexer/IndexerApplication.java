package com.lexx.indexer;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class IndexerApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        context = SpringApplication.run(IndexerApplication.class, args);

    }

    public void printServiceIsRunningMessage() {
        LexxLogger log = context.getBean(LexxLogger.class);
        log.print("Indexer Service is Running!");
    }
}
