package com.eileen;

import com.eileen.data.ApiSearch;
import com.eileen.presentation.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    Menu menu;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menu.startMenu();
//        ApiSearch apiSearch = restTemplate.getForObject("http://www.omdbapi.com/?s=batman&apikey=thewdb", ApiSearch.class);
//        log.info(apiSearch.toString());
    }



}
