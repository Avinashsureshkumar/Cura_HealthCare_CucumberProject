package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

    public static HashMap<String, String> storeValues = new HashMap<String, String>();

    public static List<HashMap<String, String>> data(String filepath, String sheetName) {
        List<HashMap<String, String>> mydata = new ArrayList<>();

        try (FileInputStream fs = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(fs)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in " + filepath);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not have a header row");
            }

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    continue;
                }

                HashMap<String, String> currentHash = new HashMap<>();
                for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String headerCellValue = headerRow.getCell(j).getStringCellValue();
                    switch (currentCell.getCellType()) {
                        case STRING:
                            currentHash.put(headerCellValue, currentCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            currentHash.put(headerCellValue, String.valueOf(currentCell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            currentHash.put(headerCellValue, String.valueOf(currentCell.getBooleanCellValue()));
                            break;
                        case BLANK:
                            currentHash.put(headerCellValue, "");
                            break;
                        default:
                            System.err.println("Unexpected cell type: " + currentCell.getCellType());
                            break;
                    }
                }
                mydata.add(currentHash);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return mydata;
    }
}
