package com.gmail.technicalTest;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class GmailTest {
  
  WebDriver driver;	
  Logger log ;
  @BeforeMethod
  public void setup(){
	  log = Logger.getLogger("devpinoyLogger");
	  log.debug("Starting Test: Initializing Driver");
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
	
  @Test
  public void Tests() {
	  log.debug("Navigating to gmail.com");
	  driver.get("http://gmail.com/");
	  WebElement username=driver.findElement(By.name("Email"));
	  Assert.assertTrue(username.isDisplayed(), "Username webelement is not present");
	  log.debug("Entering the username");
	  username.sendKeys("test21232334@gmail.com");
	  log.debug("clicking on the next button");
	  driver.findElement(By.id("next")).click();
	  WebElement password = driver.findElement(By.name("Passwd"));
	  Assert.assertTrue(password.isDisplayed(),"Password webelement is not present");
	  log.debug("Entering the password");
	  password.sendKeys("Tester@123");
	  WebElement signin_button=driver.findElement(By.id("signIn"));
	  Assert.assertTrue(signin_button.isDisplayed(),"signin button is not present");
	  log.debug("Clicking on the signin button");
	  signin_button.click();
	  WebElement compose=driver.findElement(By.xpath("//div[@class='aic']/div/div"));
	  //Assert to check whether signed in properly or not
	  Assert.assertTrue(compose.isDisplayed(),"Login was not successful");
	  log.debug("Clicking on compose button to send email");
	  compose.click();
	  //entering the receipt email address
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("bhushan.nimgaonkar@gmail.com");
	  //entering the subject
	  driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Hi");
	  //entering the message body
	  driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hello world");
	  //clicking on the send button
	  log.debug("Sending email");
	  driver.findElement(By.xpath("//div[@aria-label='Send ‪(Ctrl-Enter)‬']")).click();
	  
	  
	  
  }
  

  @AfterMethod
  public void tearDown() {
	  //performing logout operation
	  log.debug("Performing logout operation");
	  driver.findElement(By.xpath("//a[contains(@title,'Google Account:')]")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
	  driver.close();
  }

}
