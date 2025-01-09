package com.assessment.enzigmaassessment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupPageValidation extends Configuration
{
	
	@Test
	public void validateSignupPageWithValidData()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//Enter Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(read.getLastName());
		//Enter password
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys(read.getPassword());
		//Enter Confirm password
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).sendKeys(read.getConfirmPassword());
		//Click on Register
		driver.findElement(By.xpath("//div[@title='Register']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@title='Manage Profile']")).isDisplayed(),"Account not created!!");
	}
	
	@Test(description = "Email ID textfield is blank")
	public void validateSignupPageWithoutEnteringEmail()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		
		WebElement emailError = driver.findElement(By.xpath("//h2[text()='Please enter email']"));
		System.out.println("Text:"+emailError.getText());
		Assert.assertTrue(emailError.isDisplayed(),"Please enter email error message not displayed");
	}
	
	@Test(description = "First name textfield is blank")
	public void validateSignupPageWithoutFirstName()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		//wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		//Enter Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(read.getLastName());
		//validate
		String actualMessage=driver.findElement(By.xpath("//div[text()=' This field is required ']")).getText();
		Assert.assertTrue(actualMessage.contains("This field is required"));
	}
	
	@Test(description = "Last name textfield is blank")
	public void validateSignupPageWithoutLastName()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		//wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//keep last name blank
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("");
		//Enter password
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys(read.getPassword());
		WebElement error = driver.findElement(By.xpath("//div[text()=' This field is required ']"));
		Assert.assertTrue(error.isDisplayed(),"This field is required error message not displayed");
	}
	
	@Test(description = "Password textfield is blank")
	public void validateSignupPageWithoutPassword()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		//wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//Enter Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(read.getLastName());
		//keep password field empty
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("jdj");
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).clear();
		//Enter Confirm password
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).sendKeys(read.getConfirmPassword());
		WebElement error = driver.findElement(By.xpath("//div[text()=' Password must contain at least eight characters. ']"));
		Assert.assertTrue(error.isDisplayed(),"Password must contain at least eight characters error message not displayed");
	}
	
	@Test(description = "Password textfield is blank")
	public void validateSignupPageWithoutConfirmPassword()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		//wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//Enter Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(read.getLastName());
		//Enter password
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys(read.getPassword());
		//Keep Confirm password field empty
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).sendKeys("jjdji");
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).clear();
		WebElement error = driver.findElement(By.xpath("//div[text()=' The password and confirmation password do not match ']"));
		Assert.assertTrue(error.isDisplayed(),"The password and confirmation password do not match error message not displayed");
	}
	
	@Test
	public void validateEmailFormat()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter invalid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("gdh@jdk");
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		WebElement error = driver.findElement(By.xpath("//h2[text()='Please enter a valid email']"));
	    Assert.assertTrue(error.isDisplayed(),"Please enter a valid email error message not displayed");
	}
	
	@Test
	public void validatePasswordFormat()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//Enter Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(read.getLastName());
		//Enter password
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys("gdh12");
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()=' Password must contain at least eight characters. ']")).isDisplayed(),"Password error not displayed");
	}
	
	@Test
	public void validatePasswordNotMatching()
	{
//		click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//Enter Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(read.getLastName());
		//Enter password
		driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys(read.getPassword());
		//Enter Confirm password
		driver.findElement(By.xpath("//input[@name='password-confirmpassword']")).sendKeys("hsjjd");
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()=' The password and confirmation password do not match ']")).isDisplayed(),"Password and confirmation password do not match error message not displayed");
	}
	
	@Test
	public void validateFirstNameFormat()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		
		//Enter invalid First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("ashish@12");
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']")).isDisplayed(),"Special characters are not allowed error message not displayed");
	}
	
	@Test
	public void validateLastNameFormat()
	{
		//click on sign up
		driver.findElement(By.linkText("Sign up")).click();
		//enter valid email id
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		//click on checkbox
		driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']")).click();
		//click on proceed
		driver.findElement(By.xpath("(//div[@id='staticElement'])[8]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Last Name']")));
		
		//Enter First name
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(read.getFirstName());
		//Enter invalid Last name
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar12");
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()=' Special characters are not allowed ']")).isDisplayed(),"Special characters are not allowed error message not displayed");
	}
		
}
