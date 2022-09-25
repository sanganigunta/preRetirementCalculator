package com.qa.preretirementcalculator.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RetirementCalculatorPage {

	
	 WebDriver driver;
	 Actions action;
	
	public RetirementCalculatorPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	private By age = By.id("current-age");
	private By retirementAge = By.id("retirement-age");
	private By currentIncome = By.xpath("//input[@id='current-income']");
	private By spouseIncome = By.cssSelector("#spouse-income");
	private By currentTotal_savings = By.cssSelector("input#current-total-savings");
	private By currentAnnualSavings = By.xpath("//input[@id='current-annual-savings']");
	private By savingsIncreaseRate = By.id("savings-increase-rate");
	private By socialSecurityYes = By.xpath("//label[@for='yes-social-benefits']");
	private By socialSecurityNo = By.xpath("//label[@for='no-social-benefits']");
	private By maritalStatusSingle = By.id("marital-status-label");
	private By calculateBtn = By.xpath("//button[@data-tag-id='submit']");
	
	////label[@for='no-social-benefits']

	
	
	
	public String getRetirementCalculatorPageTitle()
	{
		String title = driver.getTitle();
		System.out.println("Title of the page is "+title);
		return title;
	}
	
	public String getRetirementCalculatorPageUrl()
	{
		String url = driver.getCurrentUrl();
		System.out.println("Title of the page is "+url);
		return url;
	}
	
	public MonthlySavingsGraph calculateRetirementSavings(String ageVal, String retirement_ageVal, String current_incomeVal,String spouse_incomeVal,
			String current_total_savingsVal,String current_annual_savingsVal, String savings_increase_rateVal, String socialSecurity ) throws InterruptedException
	{
		
	action = new Actions(driver);
		
		driver.findElement(age).sendKeys(ageVal);
		
		driver.findElement(retirementAge).sendKeys(retirement_ageVal);
		
	
		action.moveToElement(driver.findElement(currentIncome)).click(driver.findElement(currentIncome)).sendKeys(current_incomeVal).build().perform();
		
		
		action.moveToElement(driver.findElement(spouseIncome)).click(driver.findElement(spouseIncome)).sendKeys(spouse_incomeVal).build().perform();
		
		
		action.moveToElement(driver.findElement(currentTotal_savings)).click(driver.findElement(currentTotal_savings)).sendKeys(current_total_savingsVal).build().perform();
		

		driver.findElement(currentAnnualSavings).sendKeys(current_annual_savingsVal);
		

		driver.findElement(savingsIncreaseRate).sendKeys(savings_increase_rateVal);
		if(socialSecurity.equalsIgnoreCase("no"))
		{
			driver.findElement(socialSecurityNo).click();
		}
		else
		{
			driver.findElement(socialSecurityYes).click();
			driver.findElement(maritalStatusSingle).isDisplayed();
			
		}
	
		driver.findElement(calculateBtn).click();
		
		return new MonthlySavingsGraph(driver);
		
	}
}
