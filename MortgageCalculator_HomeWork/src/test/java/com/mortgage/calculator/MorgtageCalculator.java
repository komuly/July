package com.mortgage.calculator;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MorgtageCalculator {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/test/resources/chromedriver.exe"); driver = new ChromeDriver();
		 */

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(3 * 1000);
		driver.close();

	}

	@Test
	public void mortgageCalculator_Test() throws Exception {

		driver.get("https://www.mortgagecalculator.org/");

		String browserTitle = driver.getTitle();
		System.out.println("website Title: " + browserTitle);
		Thread.sleep(3 * 1000);

		/*
		 * driver.navigate().back(); Thread.sleep(2 * 1000);
		 * driver.navigate().forward(); Thread.sleep(2 * 1000); List<WebElement>
		 * links = driver.findElements(By.tagName("a")); int counter = 1; for
		 * (WebElement temp : links) { // System.out.println(counter
		 * +">Link Text : " + temp.getText()); String textValue =
		 * temp.getText(); if (!textValue.isEmpty()) // if(textValue.isEmpty())
		 * { System.out.println(counter + ">Link Text :" + textValue); }
		 * counter++;
		 * 
		 * }
		 */
		// driver.navigate().refresh();

		WebElement ViewLoanBreakdown = driver.findElement(By.id("toggle_pie"));
		ViewLoanBreakdown.click();

		Thread.sleep(2 * 1000);

		WebElement homeValue = driver.findElement(By.name("param[homevalue]"));
		homeValue.clear();
		homeValue.sendKeys("400000");

		Thread.sleep(2 * 1000);

		WebElement loanAmnt = driver.findElement(By.id("loanamt"));
		loanAmnt.clear();
		loanAmnt.sendKeys("15000");

		Thread.sleep(2 * 1000);

		WebElement interestRt = driver.findElement(By.name("param[interest_rate]"));
		interestRt.clear();
		interestRt.sendKeys("5");

		Thread.sleep(2 * 1000);

		WebElement todaysBestMrgRt = driver.findElement(By.cssSelector(".rw-box.center-position.best-mortgage"));
		todaysBestMrgRt.click();

		Thread.sleep(2 * 1000);

		WebElement Xbtn = driver.findElement(By.id("cboxClose"));
		Xbtn.click();

		Thread.sleep(3 * 1000);

		WebElement loanTerm = driver.findElement(By.name("param[term]"));
		loanTerm.clear();
		loanTerm.sendKeys("35");

		Thread.sleep(2 * 1000);
		/*
		 * WebElement strMonth =
		 * driver.findElement(By.name("param[start_month]")); strMonth.clear();
		 * strMonth.sendKeys("Dec");
		 * 
		 * //Thread.sleep(2 * 1000);
		 * 
		 * 
		 * WebElement strYear =
		 * driver.findElement(By.name("param[start_year]")); strYear.clear();
		 * strYear.sendKeys("2018");
		 * 
		 * Thread.sleep(2 * 1000);
		 */

		WebElement propertyTax = driver.findElement(By.id("pptytax"));
		propertyTax.clear();
		propertyTax.sendKeys("1.30");

		Thread.sleep(2 * 1000);

		WebElement PMI = driver.findElement(By.name("param[pmi]"));
		PMI.clear();
		PMI.sendKeys("0.49");

		Thread.sleep(2 * 1000);

		WebElement insurance_Year = driver.findElement(By.id("hoi"));
		insurance_Year.clear();
		insurance_Year.sendKeys("1001");

		Thread.sleep(2 * 1000);

		WebElement monthlyHOA = driver.findElement(By.name("param[hoa]"));
		monthlyHOA.clear();
		monthlyHOA.sendKeys("1");

		Thread.sleep(2 * 1000);

		WebElement CalBtn = driver.findElement(By.name("cal"));
		CalBtn.click();

		Thread.sleep(3 * 1000);

	}

}
