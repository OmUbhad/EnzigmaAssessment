package com.assessment.enzigmaassessment;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginPageValidation extends Configuration
{
	//Valid credentials
	@Test
	public void validateLoginPagewithValidCredentials()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(read.getEmail());
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(read.getPassword());
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Manage Profile']")));
		Assert.assertTrue(driver.findElement(By.xpath("//span[@title='Manage Profile']")).isDisplayed(),"Login Failed!!");
	}
	
	//Non-registered email
	@Test
	public void validateLoginPagewithNonRegisteredEmail()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(read.getPassword());
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Invalid Email or Password']")).isDisplayed(),"Invalid Email or Password error message not displayed");
	}
	
	//invalid email
	@Test
	public void validateLoginPagewithInvalidEmail()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(read.getPassword());
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Please enter a valid email']")).isDisplayed(),"Please enter a valid email error message not displayed");
	}
	
	    //invalid password
		@Test
		public void validateLoginPagewithInvalidPassword()
		{
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(read.getEmail());
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("jdk@12233");
			driver.findElement(By.xpath("//div[text()='Log In']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Invalid Email or Password']")).isDisplayed(),"Invalid Email or Password error message not displayed");
		}
		
		//Blank email field
		@Test
		public void validateLoginPagewithBlankEmailField()
		{
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(read.getPassword());
			driver.findElement(By.xpath("//div[text()='Log In']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Please enter email']")).isDisplayed(),"Please enter email error message not displayed");
		}
		
		//Blank password field
		@Test
		public void validateLoginPagewithBlankPasswordField()
		{
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(read.getEmail());
			driver.findElement(By.xpath("//div[text()='Log In']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Please enter password']")).isDisplayed(),"Please enter password error message not displayed");
		}
		
		//Blank email and password field
		@Test
		public void validateLoginPagewithBlankEmailAndPasswordField()
		{
			driver.findElement(By.xpath("//div[text()='Log In']")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Please enter email']")).isDisplayed(),"Please enter email error message not displayed");
		}
}
