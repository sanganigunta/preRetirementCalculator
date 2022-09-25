package com.qa.preretirementcalculator.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.preretirementcalculator.base.BaseTest;
import com.qa.preretirementcalculator.pages.MonthlySavingsGraph;
import com.qa.preretirementcalculator.pages.RetirementCalculatorPage;
import com.qa.preretirementcalculator.utilities.Constants;
import com.qa.preretirementcalculator.utilities.ExcelUtility;

public class RetirementCalculatorTest extends BaseTest{
	
	@BeforeClass()
	public void RetirementCalculatorTestSetup()
	{
		rcp = new RetirementCalculatorPage(driver);
	}
	
	
	@Test(priority=1)
	public void getRetirementCalculatorTitleTest()
	{
		String pageTitle = rcp.getRetirementCalculatorPageTitle();
		System.out.println("getRetirementCalculatorPageTitle is "+pageTitle);
		Assert.assertEquals(pageTitle, Constants.RETIREMENT_CALCULATOR_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getRetirementCalculatorUrlTest()
	{
		String pageUrl = rcp.getRetirementCalculatorPageUrl();
		System.out.println("getRetirementCalculatorPageTitle is "+pageUrl);
		Assert.assertTrue(pageUrl.contains(Constants.RETIREMENT_CALCULATOR_PAGE_URL_FRACTION));
	}
	
	@DataProvider()
	public Object[][] calculateRetirementSavingsData()
	{
		Object[][] data = ExcelUtility.getExcelSheetData("calculator");
		return data;
	}
	
	@Test(dataProvider="calculateRetirementSavingsData")
	public void calculateRetirementSavingsTest(String currentAge, String retirementAge, String currentAnnualIncome,String spousAnnualIncome,
			String currentRetirementSavings,String currentRetirementContribution, String annualRetirementContributionIncrease, String socialSecurityIncome) throws InterruptedException
	{
		msg = rcp.calculateRetirementSavings(currentAge,retirementAge,currentAnnualIncome,spousAnnualIncome,currentRetirementSavings,currentRetirementContribution,annualRetirementContributionIncrease,socialSecurityIncome);
	   Thread.sleep(40000);
		String textMsg = msg.getSucessMessage();
	   System.out.println(textMsg);
	   Assert.assertTrue(textMsg.contains(Constants.SUCCESSMSG_FRACTION));
	}
	

	
}

