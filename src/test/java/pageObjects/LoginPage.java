package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//Locators

@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	
	
	//Action Methods


public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}


public void setpassword(String password)
{
	txtPassword.sendKeys(password);
}

public void clickLogin()
{
	btnLogin.click();
}



	
	
	
}
