package com.br.currentweather.steps;

import com.br.currentweather.utils.Constants;
import com.br.currentweather.utils.RestFilter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.Matchers;

import java.time.LocalDateTime;

import static com.br.currentweather.utils.logUtils.printHour;
import static com.br.currentweather.utils.logUtils.printTime;

@Log4j2
public class Hooks extends Constants {

    private static LocalDateTime timeInit;

    public static RestFilter filter;

    public Hooks() {
        filter = RestFilter.getINSTANCE();
    }

    @BeforeStep
    public static void setup() {
        RestAssured.baseURI = DEFAULT_API_URL;
        RestAssured.filters(filter);
        RestAssured.baseURI = DEFAULT_API_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(APP_CONTENT_TYPE)
                .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(MAX_TIMEOUT))
                .build();
    }

    @Before
    public void setUp(Scenario scenario) {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        timeInit = LocalDateTime.now();
        log.info("----------------------------NEW SCENARIO----------------------------------");
        printHour("Inital Hour.......", LocalDateTime.now());
        log.info("Iniciando o cenário: " + scenario.getName());
    }


    @After
    public void tearDown(Scenario scenario) {
        log.info("Finalizando o cenário: " + scenario.getName() + " com o status: " + scenario.getStatus());
        LocalDateTime timeFinal = LocalDateTime.now();
        printHour("Final Hour........", LocalDateTime.now());
        timeFinal = timeFinal.minusHours(timeInit.getHour()).minusMinutes(timeInit.getMinute()).minusSeconds(timeInit.getSecond());
        printTime("Time of execution.", timeFinal);
    }


}
