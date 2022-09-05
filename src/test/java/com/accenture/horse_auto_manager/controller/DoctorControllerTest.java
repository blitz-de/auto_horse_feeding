package com.accenture.horse_auto_manager.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DoctorControllerTest {

    private final String url = "/api/doctors";

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
    void create() {

        Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", "2");
        param.put("firstname", "Laura");
        param.put("lastname", "Kiesewetter");
        param.put("address", "Schlossstr. 15");
        param.put("plz", "12514");
        param.put("gender", "f");
        param.put("city", "Brandenburg");
        param.put("age", "38");
        param.put("occupation", "best veterinarian in Brandenburg");
        param.put("medicalDegree", "doctor");

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(param)
                .when()
                .post(url+"/create")
                .then()
                .body("id", is(2))
                .body("firstname", is("Laura"))
                .body("lastname", is("Kiesewetter"))
                .body("address", is("Schlossstr. 15"))
                .body("plz", is("12514"))
                .body("gender", is("f"))
                .body("city", is("Brandenburg"))
                .body("age", is("38"))
                .body("occupation", is("best veterinarian in Brandenburg"))
                .body("medicalDegree", is("doctor"))
                .status(HttpStatus.CREATED);
    }

    @Test
    void getDoctorByID() {
    }

    @Test
    void getAllDoctors() {
    }
}