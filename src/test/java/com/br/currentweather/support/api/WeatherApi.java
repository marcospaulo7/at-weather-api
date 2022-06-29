package com.br.currentweather.support.api;

import com.br.currentweather.support.domain.City;
import com.br.currentweather.utils.RestFilter;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import static com.br.currentweather.utils.Constants.DEFAULT_API_KEY;
import static io.restassured.RestAssured.given;

@Log4j2
public class WeatherApi {
    private static final String WEATHER_ENDPOINT = "/weather";
    public RestFilter filter;

    private Response response;

    public WeatherApi() {
        filter = RestFilter.getINSTANCE();
    }

    public Response getWeatherByName(City city) {
        try {
            response = given()
                    .queryParam("appid", DEFAULT_API_KEY)
                    .queryParam("q", city.getCityName() + "," + city.getCountryCode())
                    .queryParam("units", city.getUnits())
                    .when()
                    .get(WEATHER_ENDPOINT);
        } catch (Exception error) {
            log.error("the following error occurred:" + error);
        }
        return response;
    }

    public Response getWeatherById(City city) {
        try {
            response = given()
                    .queryParam("appid", DEFAULT_API_KEY)
                    .queryParam("id", city.getId())
                    .queryParam("units", city.getUnits())
                    .when()
                    .get(WEATHER_ENDPOINT);
        } catch (Exception error) {
            log.error("the following error occurred:" + error);
        }
        return response;
    }

    public Response getWeatherByZipCode(City city) {
        try {
            response = given()
                    .queryParam("appid", DEFAULT_API_KEY)
                    .queryParam("zip", city.getZipCode())
                    .queryParam("units", city.getUnits())
                    .when()
                    .get(WEATHER_ENDPOINT);
        } catch (Exception error) {
            log.error("the following error occurred:" + error);
        }
        return response;
    }

    public Response getWeatherByCordinates(City city) {
        try {
            response = given()
                    .queryParam("appid", DEFAULT_API_KEY)
                    .queryParam("lat", city.getLatitude())
                    .queryParam("lon", city.getLongitude())
                    .queryParam("units", city.getUnits())
                    .when()
                    .get(WEATHER_ENDPOINT);
        } catch (Exception error) {
            log.error("the following error occurred:" + error);
        }
        return response;
    }


    public Response getWeatherWithoutAuth() {
        try {
            response = given()
                    .queryParam("q", "")
                    .queryParam("units", "metric")
                    .when()
                    .get(WEATHER_ENDPOINT);
        } catch (Exception error) {
            log.error("the following error occurred:" + error);
        }
        return response;
    }
}
