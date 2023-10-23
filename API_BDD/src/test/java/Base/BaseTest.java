package Base;

import Stepdefinitions.BackgrountStepdef;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BaseTest {

    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static String ClientID;
    public static String SecretKey;
    public static Response response;
    public static ThreadLocal<String> testdataID = new ThreadLocal<>();
    public static ThreadLocal<String> ScenarioName = new ThreadLocal<>();
    public static String TC = ScenarioName.get();
    public static String Query;
    public static void setup() throws FilloException {
        try {
            fis = new FileInputStream("src/test/resources/Properties/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = config.getProperty("baseURI");
        RestAssured.basePath = config.getProperty("basePath");
        ClientID = config.getProperty("paypalClientID");
        SecretKey = config.getProperty("paypalSecret");
        ScenarioName.set(testdataID.get());
    }


}
