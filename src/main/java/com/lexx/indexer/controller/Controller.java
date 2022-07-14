package com.lexx.indexer.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/status")
public class Controller {

    @GetMapping("/{id}")
    public String status(@PathVariable int id) {
        return "its responding" + new Date();
    }
}

