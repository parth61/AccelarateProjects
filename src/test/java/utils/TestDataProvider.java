package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "contactSalesData")
    public static Object[][] getData() {
        return ExcelUtil.getExcelData("Sheet1");
    }
}
