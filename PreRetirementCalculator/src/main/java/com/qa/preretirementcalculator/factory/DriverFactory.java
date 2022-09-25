package com.qa.preretirementcalculator.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.preretirementcalculator.utilities.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;
	Properties prop;

	
	public WebDriver int_driver(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		System.out.println("Given browser is "+browserName);
		if(browserName.equalsIgnoreCase(Constants.CHROME_BROWSER_NAME))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				}
		else if(browserName.equalsIgnoreCase(Constants.FIREFOX_BROWSER_NAME))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase(Constants.EDGE_BROWSER_NAME))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter the correct browser "+browserName);
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		return driver;
	}
	
	public Properties init_properties()
	{
		String filePath=".\\src\\resources\\test\\config\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
