package de.sldo.tqs;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ashraf
 *
 */
public class CSVWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Priorität,Durchführung,Testtyp,Bereich,Kurzbeschreibung,Soll-Verhalten,Tester,Kommentar,Smoketest";


    public static void main(String[] args) {

        //String fileName = System.getProperty("user.home")+"/student.csv";
        //String fileName = "testcases.csv";

        //System.out.println("Write CSV file:");
       // CSVWriter.writeCsvFile(fileName);
    }


    public static void writeCsvFile(String fileName, String input) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
          //  for (int i=0;i<10;i++) {
                fileWriter.append(input);
                fileWriter.append(COMMA_DELIMITER);
          //  }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}