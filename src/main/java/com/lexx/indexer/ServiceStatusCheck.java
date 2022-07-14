package com.lexx.indexer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Component
public class ServiceStatusCheck {

    @Autowired
    LexxLogger log;

    @Autowired
    RestTemplate restTemplate;

    public static final String URL = "http://localhost:8080";
    public static final String STATUS_PATH = "/status";
    public static final String ITEM_BY_ID_PATH = "/" + new Random().nextInt(10);

    @Scheduled(fixedDelay = 10*1000 )
    private void scheduledServiceSelfCheck() {

        printStatus();
        printItemByIdResult();
    }

    private void printStatus() {

        String response = getRequest(URL, STATUS_PATH);
        log.print("Response to : " + URL + STATUS_PATH + ": " + response);

    }

    private void printItemByIdResult() {

        String response = getRequest(URL, ITEM_BY_ID_PATH);
        log.print("Response to : " + URL + ITEM_BY_ID_PATH + ": " + response);
    }

    private String getRequest(String url, String path) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate
                .exchange(url + path, HttpMethod.GET, entity, String.class)
                .getBody();

    }


}
