package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClassCommonMethods;

public class TC0001_AccountRegistration extends BaseClassCommonMethods{

	
	@Test
	public void verify_accountregistration()
	{
		
		logger.info("starting TC0001_AccountRegistration......");
		
		try
      {
			
		
		HomePage hp =new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on my account link....");
		hp.clickRegister();
		logger.info("clicked on register link.....");
		
		AccountRegistration regpage = new AccountRegistration(driver);
		
		logger.info("providing user registration details.....");
		 regpage.setFirstname(randomString().toUpperCase());
		 regpage.setLastname(randomString().toUpperCase());
		 regpage.setEmail(randomString()+"@gmail.com");
		 regpage.setTelephone(randomNumber());
		 
		 String password = randomAlphaNumeric();
		 
		 regpage.setPassword(password);
		 regpage.setConfirmpassword(password);
		 regpage.setPrivacypolicy();
		 regpage.clickContinue();
		 
		 logger.info("validating expected message....");
		 
		 String confmessage=regpage.getConfirmationMsg();
		 if(confmessage.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				
				Assert.assertTrue(false);
			}
		
      }
		 catch(Exception e)
		{
			 
			
			 Assert.fail();
		}
		
		
		logger.info("finished TC0001_AccountRegistration.....");
		
	}
	
	
	
	
	
	
}
