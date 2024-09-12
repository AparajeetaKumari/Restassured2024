package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String readConfigs(String keyName) {
		Properties prop = new Properties();
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/Config/config.properties"));
			prop.load(fis);
			value = prop.getProperty(keyName);
		}catch(FileNotFoundException e) {
			System.out.println("Could not find the file::"+e.getMessage());
			
		}
		catch (IOException e) {
			System.out.println("Could not load/operate the file::"+e.getMessage());
		}
		
		return value;
		
	}

	
}
