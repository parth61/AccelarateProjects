package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtil {

    public  static String getData(int row, int col) throws Exception {
        FileInputStream fis = new FileInputStream("testdata/ContactSales.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String data = sheet.getRow(row).getCell(col).toString();
        workbook.close();
        return data;
    }
}
