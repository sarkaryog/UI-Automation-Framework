package com.qdpm.operations.utility;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.HashMap;

/**
 * This class can be used as read data from Excel file
 */
public class ExcelReader  {

    String filePath;
    Sheet sheet;

    @SneakyThrows
    public ExcelReader(String sheetName)  {
        filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/TestData.xlsx";
        File file = new File(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        sheet = workbook.getSheet(sheetName);
    }

    /**
     * get test data from excel sheet in hashmap based on row number
     *
     * @param rowNum
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public HashMap<String, String> getTestDataInMap(int rowNum) throws Exception {
        //read data row by row and put in map
        HashMap<String, String> stringHashMap = new HashMap<String, String>();
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            String value;
            if (sheet.getRow(rowNum).getCell(i) != null) {
                sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
                value = sheet.getRow(rowNum).getCell(i).toString();
            } else {
                value = "";
            }
            stringHashMap.put(sheet.getRow(0).getCell(i).toString(), value);
        }
        return stringHashMap;
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getCellCount() {
        return sheet.getRow(0).getLastCellNum();
    }
}
