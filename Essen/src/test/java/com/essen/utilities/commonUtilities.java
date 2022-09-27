package com.essen.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonUtilities 
{

	
	public String RandomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public static String RandomNumbers() {
		String generatedNumeric = RandomStringUtils.randomNumeric(10);
		return generatedNumeric;
	}
	public void impliciteWait(WebDriver driver, int secTime)
	{
		driver.manage().timeouts().implicitlyWait(secTime, TimeUnit.SECONDS);
	}
	public void expliciteWait(WebDriver driver, int secTime)
	{
		WebDriverWait expWait=new WebDriverWait(driver, secTime);
	}
	
	public void takeScreenshot(WebDriver driver, String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File Target=new File(System.getProperty("user.dir")+"/screenshot/"+ tname+"_"+ timeStamp+".png");
		FileUtils.copyFile(Source, Target);
	}
}
