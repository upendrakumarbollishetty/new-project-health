package excelData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataReader {

    public static List<Object[]> readTestData(String filePath, String sheetName) throws IOException {
        List<Object[]> testData = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.iterator();
            List<Object> rowData = new ArrayList<>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowData.add(cell.getNumericCellValue());
                        break;
                    // Handle other cell types if needed
				default:
					break;
                }
            }

            testData.add(rowData.toArray());
        }

        workbook.close();
        fileInputStream.close();

        return testData;
    }
}




