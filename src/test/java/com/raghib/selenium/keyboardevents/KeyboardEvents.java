package com.raghib.selenium.keyboardevents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.raghib.selenium.BaseClass;

public class KeyboardEvents extends BaseClass {
	
	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	public static String url = "https://www.carmax.com/";
	
	//ALL WEBELEMENT
	public static WebElement elementSearchBox;
	public static WebElement elementFAQ; 
	
	//ALL LOCATORS
	public static By searchBoxXPath = By.xpath("//input[@name='search' and @class='header-search-bar-input']");
	public static By faqXPath = By.xpath("//a[@class='header-link' and text()='FAQ & support']");
	
	public static void main(String[] args) {
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		
		elementSearchBox = driver.findElement(searchBoxXPath);
		
		//WAY-1
		//elementSearchBox.sendKeys("suv", Keys.ENTER);
		
		//WAY-2
		Actions actionObj = new Actions(driver);				
		actionObj.keyDown(Keys.SHIFT).sendKeys(elementSearchBox,"suv",Keys.ENTER)
		.build().perform();		
		
		//BaseClass.quitDriver();
	}
}