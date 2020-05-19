package com.project.template.controller;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class Controller {

    @GetMapping(path = "/", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> welcome() {

        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.noCache())
                .body("Welcome!");
    }
}
