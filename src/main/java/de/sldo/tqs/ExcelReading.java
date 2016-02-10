package de.sldo.tqs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelReading {

    public static String[] csvarray = new String[10];

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStream inp = null;
        try {
            inp = new FileInputStream("test.xlsx");
            Workbook wb = WorkbookFactory.create(inp);

            for(int i=0;i<wb.getNumberOfSheets();i++) {
                System.out.println(wb.getSheetAt(i).getSheetName());
                echoAsCSV(wb.getSheetAt(i));
            }
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void echoAsCSV(Sheet sheet) {
        Row row = null;

        final DataFormatter df = new DataFormatter();


        //FILE_HEADER = "Priorität,Durchführung,Testtyp,Bereich,Kurzbeschreibung,Soll-Verhalten,Tester,Kommentar,Smoketest";

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {

                Cell cell = row.getCell(j);
                String valueAsString = ("\"" + df.formatCellValue(cell) + "\"");
                csvarray[j] = valueAsString;

                //Summary, Assignee, Reporter, Issue Type, Description, Test Type, Manual Test Steps
                //"Testfall 1", dlanger, dlanger, Test, "Dies ist ein Testfall", "Manual", "[ { ""index"": 0, ""step"": ""Step 1"", ""data"": ""Testbeschreibung"", ""result"": ""SOLL"" } ]"

            }






            String fileName = "testcases.csv";
            String convinput = csvbuild(csvarray);
            CSVWriter.writeCsvFile(fileName,convinput);
            //System.out.println(Arrays.toString(csvarray));

        }
    }

    public static String csvbuild(String[] input){




        String teststring = Arrays.toString(input);

        return teststring;

    }



}