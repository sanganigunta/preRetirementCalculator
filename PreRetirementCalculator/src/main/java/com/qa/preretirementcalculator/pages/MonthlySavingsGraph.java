package com.qa.preretirementcalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MonthlySavingsGraph {
	
	WebDriver driver;
	private By sucessmsg = By.id("result-message");
	
	public MonthlySavingsGraph(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getSucessMessage()
	{
		String successMsg = driver.findElement(sucessmsg).getText();
		return successMsg;
	}

}
