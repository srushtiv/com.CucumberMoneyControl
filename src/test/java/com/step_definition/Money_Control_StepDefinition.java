package com.step_definition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Money_Control_StepDefinition
{
   WebDriver driver;
   
	@Given("^Launch the website$")
	public void launch_the_website() throws Throwable
	{
	System.setProperty("webdriver.chrome.driver", "H:\\Selenium\\com.CucumberMoneyControl\\src\\main\\resources\\exe_file\\chromedriver.exe");
	 driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.moneycontrol.com/");
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@When("^click on the drop down box$")
	public void click_on_the_drop_down_box() throws Throwable
	{
		driver.findElement(By.xpath("//div[@class='chkMrkRdr']/a")).click();  
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,400)");
	}

	@Then("^take a screenshot$")
	public void take_a_screenshot() throws Throwable
	{
	   File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(file, new File("H:\\Selenium\\com.CucumberMoneyControl\\src\\test\\resources\\Screenshot\\screenshot.png"));
	  
	}

	@Then("^click on the Stocks in News section$")
	public void click_on_the_Stocks_in_News_section() throws Throwable 
	{
		driver.findElement(By.xpath("//a[@onclick='showMktradar()']")).click();  
	}

	@Then("^print all the information$")
	public void print_all_the_information() throws Throwable
	{
	   WebElement ele=driver.findElement(By.xpath("//div[@id='lastStock']/div[1]"));
	   System.out.println(ele.getText());
	}

}
