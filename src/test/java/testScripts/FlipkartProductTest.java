package testScripts;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Common;
import baseTest.TestBase;
import businessHelpers.AmazonFunction;
import businessHelpers.FlipkartFunction;

public class FlipkartProductTest extends TestBase{
	FlipkartFunction objFlipkartFunction;
	AmazonFunction objAmazonFunction;
	Common objSmallCommon;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		objFlipkartFunction = new FlipkartFunction();
		objAmazonFunction = new AmazonFunction();
		objSmallCommon = new Common();
	}
	
	//@Test(priority = 0 , description = "Validate Product Search and add to cart feature on flipkart") 
	@Test
	public void firstTestCase()
	{
		objFlipkartFunction.navigateToFlipkart();
		objFlipkartFunction.searchProduct("Apple iPhone XR (Yellow, 64 GB)");
		String prodName = objFlipkartFunction.verifyProductSelection();
		System.out.println("Product Name" + prodName);
		Float prodPrice = objFlipkartFunction.fetchProductPrice();
		System.out.println("Product Price" + prodPrice);
		objFlipkartFunction.addProductToCart();
	}
	
	

}
