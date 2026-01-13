package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getExcelData(String sheetName) throws Exception {
        try {
            String path = System.getProperty("user.dir") + "/testdata/ContactSales.xlsx";
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }
            }
            workbook.close();
            return data;
        }
        catch (Exception e){
            throw new RuntimeException("Excel failed to read");
        }
    }
}
