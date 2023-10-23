package Stepdefinitions;

import Base.BaseTest;
import apis.Orderapi;
import com.codoid.products.exception.FilloException;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.api.Scenario;
import org.testng.Assert;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PayPalSteps extends BaseTest {




//    public void setUp() throws FilloException {
//
//
//    }


    @Given("^I want to get access token from PayPal api$")
    public void i_want_to_get_access_token_from_PayPal_api() {



        Orderapi.getAccessToken();

    }

//    @When("^I set currency code as \"([^\"]*)\" and value as \"([^\"]*)\"$")
//    public void i_set_currency_code_and_value(String currencyCode, String currencyValue) throws JsonProcessingException {
//
//
//        BaseTest.response = Orderapi.createOrder(currencyCode, currencyValue);
//
//
//    }
    @When("I set currency code as currencyCode and value as currencyValue>")
    public void iSetCurrencyCodeAsCurrencyCodeAndValueAsCurrencyValue() throws JsonProcessingException {
        String a =BackgrountStepdef.getData("currencyValue");
        System.out.println(a);
        BaseTest.response = Orderapi.createOrder(BackgrountStepdef.getData("currencyCode"),BackgrountStepdef.getData("currencyValue"));
    }


    @When("^I get order from the paypal api$")
    public void i_get_order_from_the_paypal_api() {

        BaseTest.response = Orderapi.getOrder();
    }


    @And("^I verify the status as CREATED$")
    public void i_verify_the_status_as_created() {


        Assert.assertEquals(BaseTest.response.jsonPath().get("status").toString(), "CREATED");


    }


//    @And("^I verify the status code as \"([^\"]*)\"$")
//    public void i_verify_the_status_code_as(int statusCode) {
//
//        Assert.assertEquals(BaseTest.response.getStatusCode(), statusCode);
//    }


    @And("I verify the status code")
    public void iVerifyTheStatusCode() {
        Assert.assertEquals(BaseTest.response.getStatusCode(), Integer.parseInt(BackgrountStepdef.getData("Response")));
    }


}
