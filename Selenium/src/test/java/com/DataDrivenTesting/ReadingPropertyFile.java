package com.DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertyFile {

	public static void main(String[] args) throws IOException {
		
		
		
		//open file in reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");

		//create properties object
		Properties prop = new Properties();
		
		//load properties
		prop.load(file);
		
		//Reading data from property file
		String url = prop.getProperty("appurl"); // we have specify key
		String email = prop.getProperty("email");
		String pswd = prop.getProperty("password");
		String orid = prop.getProperty("orderid");
		String custid = prop.getProperty("customerid");
		
		System.out.println(url+" "+email+" "+pswd +" "+orid+" "+ custid);
		
		//Reading only keys - approch1
		Set<String> keys = prop.stringPropertyNames();
		System.out.println(keys);
		
		//Reading only keys - approch2
		Set<Object> keys1 = prop.keySet();
		System.out.println(keys1);
		
		//Reading only values
		Collection<Object> values = prop.values();
		System.out.println(values);
		
		file.close();
	}

}
