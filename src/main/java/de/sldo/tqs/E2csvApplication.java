package de.sldo.tqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class E2csvApplication {

	public static void main(String[] args) {SpringApplication.run(E2csvApplication.class, args);

		//String fileName = System.getProperty("user.home")+"/student.csv";
		//String fileName = "testcases.csv";

		//System.out.println("Write CSV file:");
		//CSVWriter.writeCsvFile(fileName);

	}
}
