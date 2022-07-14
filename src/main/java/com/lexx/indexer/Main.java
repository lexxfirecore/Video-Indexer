package com.lexx.indexer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Main {
    private static final LexxLogger logger = new LexxLogger();
    public static final String URL = "http://localhost:8080";
    public static final String PATH = "/status/1";

    public static void main(String[] args) {

        Main main = new Main();


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String status = main.getRestTemplate()
                .exchange(URL + PATH, HttpMethod.GET, entity, String.class)
                .getBody();

        logger.print("Response to : " + URL + PATH + ":" + status);

    }



    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
