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
    void getHorseByID() {

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .get(url+"/1")
                .then()
                .body("guid", is(1))
                .body("name", is("Markus"))
                .body("nickname", is("The unstoppable"))
                .body("breedName", is("Arabian"))
                .body("type", is("horse"))
                .body("chip_id", is(1))
                .status(HttpStatus.OK);
    }

    @Test
    void createHorse() {

        Map<String, Object> param = new HashMap<String, Object>();

        param.put("guid", "5");
        param.put("name", "Markus");
        param.put("nickname", "The unstoppable");
        param.put("color", "white");
        param.put("breedName", "Arabian");
        param.put("type", "horse");
        param.put("chip_id", 5);


        RestAssuredMockMvc.given()
                .contentType("application/json")
                .body(param)
                .when()
                .post(url+"/create")
                .then()
                .body("guid", is(5))
                .body("name", is("Markus"))
                .body("nickname", is("The unstoppable"))
                .body("color", is("white"))
                .body("breedName", is("Arabian"))
                .body("type", is("horse"))
                .body("chip_id", is(5))
                .status(HttpStatus.CREATED);
    }

    @Test
    void assignDoctorToHorse() {

        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .put(url+"/2/doctor/1")
                .then()
                .body("guid", is(2))
                .body("name", is("Francis"))
                .body("nickname", is("The invincible"))
                .body("color", is("brown"))
                .body("breedName", is("Mustang"))
                .body("type", is("horse"))
                .body("chip_id", is(2))
                .status(HttpStatus.CREATED);
    }

    @Test
    void assignStablemanToHorse() {
        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .put(url+"/3/stableman/1")
                .then()
                .body("guid", is(3))
                .body("name", is("Theodor"))
                .body("nickname", is("The wise"))
                .body("color", is("black"))
                .body("breedName", is("Banker horse"))
                .body("type", is("horse"))
                .body("chip_id", is(3))
                .status(HttpStatus.CREATED);
    }

    @Test
    void assignFoodToHorse() {
        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .put(url+"/3/food/1")
                .then()
                .body("guid", is(3))
                .body("name", is("Theodor"))
                .body("nickname", is("The wise"))
                .body("color", is("black"))
                .body("breedName", is("Banker horse"))
                .body("type", is("horse"))
                .body("chip_id", is(3))
                .status(HttpStatus.CREATED);
    }

    @Test
    void assignMedicineToHorse() {
        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .put(url+"/3/medicine/1")
                .then()
                .body("guid", is(3))
                .body("name", is("Theodor"))
                .body("nickname", is("The wise"))
                .body("color", is("black"))
                .body("breedName", is("Banker horse"))
                .body("type", is("horse"))
                .body("chip_id", is(3))
                .status(HttpStatus.CREATED);
    }

    @Test
    void deleteHorse() {
        RestAssuredMockMvc.given()
                .contentType("application/json")
                .when()
                .delete(url+"/7")
                .then()
                //.body(Respon)
                .status(HttpStatus.ACCEPTED);
    }
}