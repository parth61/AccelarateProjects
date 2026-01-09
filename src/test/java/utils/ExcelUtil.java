package utils;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtil {

    public  static String getData(int row, int col) throws Exception {
        FileInputStream fis = new FileInputStream("testdata/ContactSales.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        DataFormatter format = new DataFormatter();
        String data = format.formatCellValue(sheet.getRow(row).getCell(col));
        workbook.close();
        return data;
    }
}
