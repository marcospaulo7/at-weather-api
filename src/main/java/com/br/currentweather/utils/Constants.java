package com.br.currentweather.utils;


import io.restassured.http.ContentType;

public class Constants {


    public static final String DEFAULT_API_URL = "http://api.openweathermap.org/data/2.5";
    public static final String DEFAULT_API_KEY = "73b5c46be0c1e83874561cc759f775fc";
    public static final ContentType APP_CONTENT_TYPE = ContentType.JSON;
    public static final Long MAX_TIMEOUT = 5000L;

}
