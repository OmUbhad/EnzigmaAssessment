package com.assessment.enzigmaassessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Configuration 
{
	WebDriver driver;
	ReadConfigFile read;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		read = new ReadConfigFile();
		driver.manage().window().maximize();
		driver.get(read.getUrl());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeWindow()
	{
		if (driver != null) 
		{
            driver.quit();
        }
	}
}
