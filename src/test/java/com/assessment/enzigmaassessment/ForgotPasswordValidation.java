package com.assessment.enzigmaassessment;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordValidation extends Configuration 
{
	//Forgot password with valid email
	@Test
	public void validateForgotPasswordwithValidEmail()
	{
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys(read.getEmail());
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()=' Change Password ']")));
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(read.getPassword());
		driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys(read.getConfirmPassword());
		driver.findElement(By.xpath("//div[@title='Confirm']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Password changed successfully']")).isDisplayed());
	}
	
	//Forgot password with non-registered email
	@Test
	public void validateForgotPasswordwithNonRegisteredEmail()
	{
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='User does not exists']")).isDisplayed(),"User does not exists error message not displayed");
	}
	
	//Forgot password with invalid email
	@Test
	public void validateForgotPasswordwithInvalidEmail()
	{
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("abc@gmai");
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Please enter a valid email']")).isDisplayed(),"Please enter a valid email error message not displayed");
	}
		
	//Forgot password with blank email field
	@Test
	public void validateForgotPasswordwithBlankEmail()
	{
		driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.xpath("//div[@title='Proceed']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Please enter email']")).isDisplayed(),"Please enter email error message not displayed");
	}
}
