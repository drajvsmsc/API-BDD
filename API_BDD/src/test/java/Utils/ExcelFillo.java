package Utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ExcelFillo {

    @Test
    public void setupfillo() throws FilloException {
        Fillo fillo = new Fillo();
        Map<String, String> map = new HashMap<>();
        Connection connection = fillo.getConnection("D:\\Standalone server\\restassured\\mainRest\\API_BDD\\src\\test\\resources\\Data\\TestData.xlsx");

        String stQuery ="Select * from ApiData where TC_NUM ='TC_1'";
        Recordset recordset = connection.executeQuery(stQuery);
        while(recordset.next()) {
            System.out.println(recordset.getField("Response"));
        }
        recordset.close();
        connection.close();

    }


}
