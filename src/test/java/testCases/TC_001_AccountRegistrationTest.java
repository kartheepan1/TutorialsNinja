package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	
	@Test(groups= {"Sanity","Master"})
	public void VerifyAccountRegistration()
	{
		
		//Logs
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");

		
	try {
		
		
		HomePage HP = new HomePage(driver);
		HP.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		HP.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage ARP = new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
			
		ARP.setFirstName(randomeString().toUpperCase());
		ARP.setLastName(randomeString().toUpperCase());
		ARP.setEmail(randomeString()+"@gmail.com");
		ARP.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		ARP.setPassword(password);
		ARP.setConfirmPassword(password);
		ARP.setPrivacyPolicy();
		ARP.clickContinue();
		logger.info("Validating expected message..");
		
		String confmsg=ARP.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	
	catch (Exception e)

	{

		logger.error("Test failed: " + e.getMessage());

		Assert.fail("Test failed: " + e.getMessage());

	} 

	finally 

	{

	logger.info("***** Finished TC001_AccountRegistrationTest *****");

	}

		
		/*
		
		regpage.setFirstName(randomeString().toUpperCase());

		regpage.setLastName(randomeString().toUpperCase());

		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email

		regpage.setTelephone(randomeNumber());

		String password=randomAlphaNumeric();

		regpage.setPassword(password);

		regpage.setConfirmPassword(password);

		regpage.setPrivacyPolicy();

		regpage.clickContinue();

		String confmsg=regpage.getConfirmationMsg();
		
		*/
 
		
	}
	
	
}
