package com.accenture.horse_auto_manager.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FoodControllerTest {

    private final String url = "/api/food";

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp(){
        RestAssuredMockMvc.webAppContextSetup(context);
    }

    @AfterEach
    void cleanUp() {
        RestAssuredMockMvc.reset();
    }

    @Test
    void getAllFood() {
    }

    @Test
    void getFoodById() {
    }

    @Test
    void postFoodDTO() {
    }
}