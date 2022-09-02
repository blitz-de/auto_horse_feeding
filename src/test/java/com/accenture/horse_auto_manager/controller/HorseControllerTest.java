package com.accenture.horse_auto_manager.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HorseControllerTest {

    private final String url = "/api/horse";

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
    void getHorses() {

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .get(url+"/all")
                .then()
                .body("id", is(1))
                .body("name", is("Markus"))
                .body("nickname", is("The unstoppable"))
                .body("breedName", is("Arabian"))
                .body("type", is("horse"))
                .body("chip_id", is("124"))
                .status(HttpStatus.OK);
    }

    @Test
    void createHorse() {
        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .post(url+"/create")
                .then()
                .body("id", is(12))
                .body("name", is("Markus"))
                .body("nickname", is("The unstoppable"))
                .body("breedName", is("Arabian"))
                .body("type", is("horse"))
                .body("chip_id", is("124"))
                .body("doctorName", is(null))
                .body("stablemanName", is(null))
                .status(HttpStatus.CREATED);
    }

    @Test
    void assignDoctorToHorse() {
    }

    @Test
    void assignStablemanToHorse() {
    }

    @Test
    void assignFoodToHorse() {
    }

    @Test
    void assignMedicineToHorse() {
    }

    @Test
    void deleteHorse() {
    }
}