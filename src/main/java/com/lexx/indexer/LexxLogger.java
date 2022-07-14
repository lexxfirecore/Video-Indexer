package com.lexx.indexer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LexxLogger {



    void print(String text) {

        String textWithAsterisks = "***  " + text + "  ***";
        int length = textWithAsterisks.length();
        String line = "*".repeat(length);

        System.out.println(line);
        System.out.println(textWithAsterisks);
        System.out.println(line);
    }

    public static void main(String[] args) {
        LexxLogger logger = new LexxLogger();
        logger.print("test");
    }
}
