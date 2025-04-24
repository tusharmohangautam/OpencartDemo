package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;      //log4j

public class BaseClassCommonMethods {

	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br)
	{
		
		logger=LogManager.getLogger(this.getClass()); 
		
		switch(br.toLowerCase())  //...when we are not using Grid setup execution....//// Use grouping.xml file
		{
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default: System.out.println("Invalid browser name...");
		return; //It will come out of setup() method and stop further execution if browser name doesn't match
		} 
		
		
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	public String randomString()
	{
	    String generatedstring =	RandomStringUtils.randomAlphabetic(10);
	    return generatedstring;
	}
	
	
	public String randomNumber()
	{
		
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	
	public String randomAlphaNumeric()
	{
		String generatedstring =	RandomStringUtils.randomAlphabetic(10);
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return (generatedstring+generatednumber);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
