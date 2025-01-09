package com.assessment.enzigmaassessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile 
{
	Properties  properties;
	String path="C:\\Java workspace\\enzigmaassessment\\config.properties";
	
	public ReadConfigFile()
	{
		properties=new Properties();
		try
		{
			FileInputStream fis = new FileInputStream(path);
			try 
			{
				properties.load(fis);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
	}
	
	public String getUrl()
	{
		String url = properties.getProperty("url");
		if(url!=null)
		{
			return url;
		}
		else
		{
			throw new RuntimeException("Url is not specified in file");
		}
	}
	
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
		{
			return email;
		}
		else
		{
			throw new RuntimeException("email id is not specified in file");
		}
	}
	
	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
		{
			return password;
		}
		else
		{
			throw new RuntimeException("Password is not specified in file");
		}
	}
	public String getConfirmPassword()
	{
		String confirmPassword = properties.getProperty("confirmPassword");
		if(confirmPassword!=null)
		{
			return confirmPassword;
		}
		else
		{
			throw new RuntimeException("Confirm password is not specified in file");
		}
	}
	public String getFirstName()
	{
		String firstName = properties.getProperty("firstName");
		if(firstName!=null)
		{
			return firstName;
		}
		else
		{
			throw new RuntimeException("First Name is not specified in file");
		}
	}
	public String getLastName()
	{
		String lastName = properties.getProperty("lastName");
		if(lastName!=null)
		{
			return lastName;
		}
		else
		{
			throw new RuntimeException("Last Name is not specified in file");
		}
	}
}
