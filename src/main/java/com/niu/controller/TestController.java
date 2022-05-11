package com.niu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {


    @GetMapping("/test")
    public String test(String a) {
        log.info(" test controller test {}", a);
        return a;
    }

    @PostMapping("/testPostMan")
    public String testPostMan(String data) {
        log.info(" test controller testPostMan {}", data);
        return data;
    }


    public static void main(String[] args) {

    }
}
