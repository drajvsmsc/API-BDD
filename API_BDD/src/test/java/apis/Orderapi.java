package apis;


import java.util.ArrayList;


import Base.BaseTest;

import Pojo.Paypal1;
import Pojo.PurchaseUnits;
import Stepdefinitions.BackgrountStepdef;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Orderapi extends BaseTest {


    static String orderId;


    public static String getAccessToken() {
//        baseURI = config.getProperty("baseURI");
//        basePath = config.getProperty("basePath");

        String access_token = given().param("grant_type", "client_credentials")
                .auth().preemptive()
                .basic(ClientID, SecretKey)
                .post(baseURI + basePath)
                .jsonPath()
                .get("access_token").toString();
//        System.out.println(access_token);
        return access_token;


    }


    public static Response createOrder(String currency_code, String currency_value) throws JsonProcessingException {
        ArrayList<PurchaseUnits> list = new ArrayList<PurchaseUnits>();
        list.add(new PurchaseUnits(currency_code, currency_value));
        Paypal1 order = new Paypal1("CAPTURE", list);


//        System.out.println(fg);
        Response resposne = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(getAccessToken())
                .body(order)
                .post("https://api.sandbox.paypal.com/v2/checkout/orders");
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(order);
        System.out.println(json);
      System.out.println(  resposne.asString());

        orderId = resposne.jsonPath().get("id").toString();


        return resposne;
    }


    public static Response getOrder() {

        System.out.println("Order id is : " + orderId);
        Response resposne = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(getAccessToken())

                .get(baseURI+"/v2/checkout/orders" + "/" + orderId);
        resposne.prettyPrint();

        return resposne;
    }
}

