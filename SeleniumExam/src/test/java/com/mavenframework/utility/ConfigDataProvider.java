package com.mavenframework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Configuration/Config.properties");
 
		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to Load Config File" + e.getMessage());
		}
	}
	/*
	 * public String GetDataConfig(String searchkey) {
	 * 
	 * return pro.getProperty(searchkey);
	 * 
	 * }
	 */

	public String GetBrowser() {

		return pro.getProperty("Browser");
	}

	public String GetLowerURl() {

		return pro.getProperty("LowerURL");
	}

	public String GetStagingURL() {

		return pro.getProperty("StagingURL");

	}
	public String GetLegoURL() {

		return pro.getProperty("Lego");

	}


}
