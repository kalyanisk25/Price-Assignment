package businessHelpers;

import java.sql.Driver;

import Library.Common;
import baseTest.TestBase;
import pageClass.FlipkartPages;

public class FlipkartFunction extends TestBase {
	
	FlipkartPages objFlipkartPages;
	Common objSmallCommon;
	
	public FlipkartFunction()
	{
		objFlipkartPages = new FlipkartPages();
		objSmallCommon = new Common();
		
	}

	public void navigateToFlipkart()
	{
		driver.get("https://www.flipkart.com/");
		objFlipkartPages.closingLoginModule();
	}
	
	public void searchProduct(String productName)
	{
		objFlipkartPages.clickingonSearchBar(productName);
		objFlipkartPages.clickOnSearchButton();
		objFlipkartPages.ClickingOnFirstProduct();
	}
	
	public String verifyProductSelection() {
		objSmallCommon.navigateAndTakeControlToNewTab(0);
		
		String prodNameString = objFlipkartPages.fetchProductNameElement();
		return prodNameString;	
	}
	
	
	public float fetchProductPrice()
	{
		String prodPrice = objFlipkartPages.getProductPrice();
		return objSmallCommon.trimSpaceAndRsSymbol(prodPrice);
		
	}
	
	public void addProductToCart()
	{	
		objFlipkartPages.clickingOnAddToCartButton();
		objFlipkartPages.increasingQuantity();
		String finalPrice = objFlipkartPages.getCartPrice();
		System.out.println(objSmallCommon.trimSpaceAndRsSymbol(finalPrice));
		
		
	}
	
}
