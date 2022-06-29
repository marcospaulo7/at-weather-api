package com.br.currentweather.utils;

import com.google.gson.JsonObject;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public class RestActions {

    private RequestSpecification request;
    private Response response;
    private RestFilter restFilter;

    public RestActions() {
        restFilter = RestFilter.getINSTANCE();
    }


    public String getAllLogs() {
        return this.restFilter.getAllLogs();
    }

    public String getRequestLog() {
        return restFilter.getRequestLog();
    }

    public String getResponseLog() {
        return restFilter.getResponseLog();
    }


    public RequestSpecification getRequest() {
        return request;
    }


    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public RequestSpecification header(Header header) {
        return request.header(header);
    }


    public RequestSpecification header(String headerName, Object obj, Object... addObj) {
        return request.header(headerName, obj, addObj);
    }


    public RequestSpecification body(String body) {
        return request.body(body);
    }


    public RequestSpecification body(String property, String value) throws Exception {
        return body(getJson(property, value, new String[0]).toString());
    }


    public RequestSpecification body(String property, String value, String... add) throws Exception {
        return body(getJson(property, value, add).toString());
    }


    public JsonObject getJson(String property, String value) throws Exception {
        return getJson(property, value, new String[0]);
    }


    public JsonObject getJson(String property, String value, String... add) throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(property, value);
        try {
            for (int i = 0; i < add.length; i += 2) {
                jsonObject.addProperty(add[i], add[i + 1]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Invalid number arguments to 'property' and 'value'" + e);
        }
        return jsonObject;
    }


    public String getResponseValue(String parameter) {
        return JsonPath.from(response.asString()).get(parameter);
    }

    public List<Map<String, String>> getResponseValues(String parameter) {
        return JsonPath.from(response.asString()).get(parameter);
    }


    public String getResponseValue(Response response, String parameter) {
        return JsonPath.from(response.asString()).get(parameter);
    }


    public List<Map<String, String>> getResponseValues(Response response, String parameter) {
        return JsonPath.from(response.asString()).get(parameter);
    }


    public XmlPath getResponseXmlPath() {
        return XmlPath.from(response.asString());
    }


    public XmlPath getResponseXmlPath(Response response) {
        return XmlPath.from(response.asString());
    }

    public XmlPath getResponseHtmlPath() {
        return response.htmlPath();
    }


    public XmlPath getResponseHtmlPath(Response response) {
        return response.htmlPath();
    }
}