package com.lexx.indexer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndexerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndexerApplication.class, args);

		System.out.println("************************ Running **************************");
	}

}