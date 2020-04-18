package com.patientportal.apimethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    private String complete_endpoint;
    private String http_request_type;
    private String body;
    private int status_code;
    private String response_body;

    public String getHttp_request_type() {
        return http_request_type;
    }

    public void setHttp_request_type(String http_request_type) {
        this.http_request_type = http_request_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getResponse_body() {
        return response_body;
    }

    public void setResponse_body(String response_body) {
        this.response_body = response_body;
    }

    public String getComplete_endpoint() {
        return complete_endpoint;
    }

    public void setComplete_endpoint(String complete_endpoint) {
        this.complete_endpoint = complete_endpoint;
    }


    String base_URI = "https://demo-api.meddbase.com/patientportalapi";
//    public int perform_api_request(String endpoint, String query_params, String body) {
//        String[] params_array = query_params.split("#");
//        String[] key_val_set1= params_array[0].split(":");
//        String[] key_val_set2= params_array[1].split(":");
//
//        String complete_endpoint=base_URI+endpoint+"?"+key_val_set1[0]+"="+key_val_set1[1]+key_val_set2[0]+"="+key_val_set2[1];

    //RestAssured.baseURI = complete_endpoint;

    public int perform_api_request() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(getBody());
        Response response = requestSpecification.post(getComplete_endpoint());

        System.out.println("*** The final endpoint is: "+getComplete_endpoint());
        System.out.println("*** Response status: "+response.jsonPath().get("status"));
        System.out.println("*** Request Body json: "+getBody());
        System.out.println("*** Status code is: "+response.getStatusCode());
        System.out.println("*** Full Response body: "+response.body().prettyPrint());
        return response.getStatusCode();
    }

}
