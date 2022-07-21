package com.crm.actiTime.seleniumAfternoonBatch.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class JavaUtitlity {

	public int randomNumber(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
	
	public String getDataFromPropertyFile(String key) throws IOException {
		//Fetch data from property file
		FileInputStream fisProp = new FileInputStream("./src/test/resources/PropertyData.properties");
		Properties property=new Properties();
		property.load(fisProp);
				
		return property.getProperty(key);
				
	}
}
