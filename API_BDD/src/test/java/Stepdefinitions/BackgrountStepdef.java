package Stepdefinitions;

import Base.BaseTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackgrountStepdef extends BaseTest {
    Fillo fillo = new Fillo();
    public static Recordset recordsets;
    public static Map<String, String> columnValuesMap = new HashMap<>();
    public static List<String> columnNames;


    @Given("Setup the testdata")
    public void setupTheTestdata() throws FilloException {
        Query = "Select * from ApiData where TC_NUM ='" + ScenarioName.get() + "'";
        Connection connection = fillo.getConnection("src\\test\\resources\\Data\\TestData.xlsx");
//        System.out.println(Query);
        recordsets = connection.executeQuery(Query);


    }

    @Before
    public void readScenarioName(Scenario scenario) throws FilloException {
        testdataID.set(scenario.getName());
        ScenarioName.set(testdataID.get());
        BaseTest.setup();
    }

    public static String getData(String field) {
        try {
            columnNames = recordsets.getFieldNames();
            while (recordsets.next()) {
                for (String columnName : columnNames) {
                    String values = String.join(",", recordsets.getField(columnName));
                    columnValuesMap.put(columnName,values);
                }
            }
            return columnValuesMap.get(field);
        } catch (FilloException e) {
            e.printStackTrace();
        }

        return "";

    }


}
