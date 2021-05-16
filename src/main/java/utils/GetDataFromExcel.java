package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GetDataFromExcel {
    public static ArrayList<String> getData() throws IOException {
        FileInputStream file;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> valueList = new ArrayList<String>();
        file = new FileInputStream("D://HCM automation process-Hire.xlsx");
        XSSFWorkbook workbook;
        workbook = new XSSFWorkbook(file);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Hire an Employee")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> cell = firstrow.cellIterator();
                Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
                int k = 0;
                int coloumn = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();
                    String cellValue = value.getStringCellValue();
                    if (cellValue.equalsIgnoreCase("Values")) {
                        coloumn = k;

                    }

                    k++;
                }

////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
                while (rows.hasNext()) {

                    Row r = rows.next();
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Values")) {

////after you grab purchase testcase row = pull all the data of that row and feed into test

                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {

                                valueList.add(c.getStringCellValue());
                            } else {

                                valueList.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                            }
                        }
                    }
                }

            }


        }
        return valueList;
    }


}
