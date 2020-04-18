package com.patientportal.stepdefs;

import com.patientportal.apimethods.BaseApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginStepdefs {

    BaseApi baseApi_obj = new BaseApi();
    String base_endpoint = "https://demo-api.meddbase.com/patientportalapi";
    String temp_url="";

    @Given("^user performs \"([^\"]*)\" request with the endpoint \"([^\"]*)\"$")
    public void user_performs_request_with_the_endpoint(String req_type, String endpoint) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        baseApi_obj.setHttp_request_type(req_type);
        temp_url = base_endpoint+endpoint;
    }

    @Given("^using query params \"([^\"]*)\"$")
    public void using_query_params(String query_params) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        String[] params_array = query_params.split("#");
        String[] key_val_set1= params_array[0].split(":");
        String[] key_val_set2= params_array[1].split(":");

        String complete_endpoint=temp_url+"?"+key_val_set1[0]+"="+key_val_set1[1]+"&"+key_val_set2[0]+"="+key_val_set2[1];
        baseApi_obj.setComplete_endpoint(complete_endpoint);

    }

    @When("^user submits the request with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_submits_the_request_with_username_and_password(String uname, String pwd) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String json = "{\"username\": \"email_address\",\"password\": \"password_val\"}";
        json = json.replace("email_address",uname).replace("password_val",pwd);
        baseApi_obj.setBody(json);

    }

//    @Then("^verifies the response code \"([^\"]*)\"$")
//    public void verifies_the_response_code(int status_code) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        int return_code = baseApi_obj.perform_api_request();
//        Assert.assertEquals(return_code, status_code);
//
//    }


//    @Then("^verifies the response code <resp_code>$")
//    public void verifiesTheResponseCodeResp_code(int status_code) {
//        int return_code = baseApi_obj.perform_api_request();
//        Assert.assertEquals(return_code, status_code);
//    }

    @Then("^verifies the response code (\\d+)$")
    public void verifiesTheResponseCode(int status_code) {
        int return_code = baseApi_obj.perform_api_request();
        Assert.assertEquals(return_code, status_code);
    }
}
