package com.lexx.indexer.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/status")
    public String status() {
        return "Indexer Service Status : Running";
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        return "id =" + id;
    }
}

