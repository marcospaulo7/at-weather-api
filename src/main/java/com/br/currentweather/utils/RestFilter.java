package com.br.currentweather.utils;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.Getter;

import java.util.List;

@Getter
public class RestFilter implements Filter {
    private static RestFilter INSTANCE;

    public static RestFilter getINSTANCE() {
        if (RestFilter.INSTANCE == null) {
            synchronized (RestFilter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RestFilter();
                }
            }
        }
        return INSTANCE;
    }

    private String requestLog;
    private String responseLog;

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);

        setRequestLog(requestSpec);
        setResponseLog(response);

        return response;
    }

    private void setRequestLog(FilterableRequestSpecification requestSpec) {
        requestLog = "\nRequest => \n" + requestSpec.getMethod() + " : " + requestSpec.getURI()
                + "\nHeaders => " + printHeaders(requestSpec.getHeaders().asList())
                + "\nBody => \n" + requestSpec.getBody();
    }

    private String printHeaders(List<Header> listHeaders) {
        String header = "";
        for (Header h : listHeaders) {
            header += "\n" + h.getName() + " : " + h.getValue();
        }
        return header;
    }

    private void setResponseLog(Response response) {
        String body = null;
        try {
            body = response.getBody().prettyPrint();
        } catch (Exception e) {
            body = response.getBody().print();
        }

        responseLog = "\nResponse => \n" + response.getStatusCode() + " : " + response.getStatusLine()
                + "\nHeaders => " + printHeaders(response.getHeaders().asList())
                + " \nBody => " + body;
    }

    public String getAllLogs() {
        return requestLog + responseLog;
    }
}