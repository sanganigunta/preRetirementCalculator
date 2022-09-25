package com.qa.preretirementcalculator.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.preretirementcalculator.factory.DriverFactory;
import com.qa.preretirementcalculator.pages.MonthlySavingsGraph;
import com.qa.preretirementcalculator.pages.RetirementCalculatorPage;

public class BaseTest {
	
	
	DriverFactory df;
	public WebDriver driver;
	Properties prop;
	public RetirementCalculatorPage rcp;
	public MonthlySavingsGraph msg;
	
	@BeforeTest()
	public void setup()
	{
		df = new DriverFactory();
		prop = df.init_properties();
		driver = df.int_driver(prop);
	}
	
	@AfterTest()
	public void tearDown()
	{
		//driver.close();
	}

}
