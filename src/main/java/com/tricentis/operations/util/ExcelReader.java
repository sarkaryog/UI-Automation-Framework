package com.tricentis.operations.util;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelReader {

    String filePath;
    Sheet sheet;

    @SneakyThrows
    public ExcelReader(String sheetName) throws IOException {
        filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
        File file = new File(filePath);
        Workbook wb = WorkbookFactory.create(file);
        sheet = wb.getSheet(sheetName);
    }

    @SneakyThrows
    public HashMap<String, String> getTestDataInMap(int rowNum) throws IOException {
        sheet.getRow(0).getCell(1).toString();
        // Read data row by row and put in map
        HashMap<String, String> stringHashMap = new HashMap<String, String>();
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            stringHashMap.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNum).getCell(i).toString());
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
