package testScripts;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Common;
import baseTest.TestBase;
import businessHelpers.AmazonFunction;
import businessHelpers.FlipkartFunction;

public class PriceComparisionTest extends TestBase{
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
	

	//@Test (priority = 0 , description = "Validate Product Search and compare prices on flipkart & Amazon")
	@Test
	public void secondTestCase()
	{
		objFlipkartFunction.navigateToFlipkart();
		objFlipkartFunction.searchProduct("Apple iPhone XR (Yellow, 64 GB)");
		String flipKartProductName = objFlipkartFunction.verifyProductSelection();
		Float flipkartProdPrice = objFlipkartFunction.fetchProductPrice();
		System.out.println("Flipkart product price " + flipkartProdPrice);
		
		objAmazonFunction.navigateToAmazon();
		objAmazonFunction.searchProduct("Apple iPhone XR (Yellow, 64 GB)");
		objAmazonFunction.selectProd(flipKartProductName);
		Float amazonProdPrice = objAmazonFunction.FetchPrice();	
		System.out.println("Amazon Product Price " + amazonProdPrice);
		
		objSmallCommon.comparePrices(flipkartProdPrice,amazonProdPrice);
	}

	

}
