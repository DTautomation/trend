package trendYol.Bölüm1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.testng.annotations.Test;




public class MainTest extends ParameterForBrowser {
	 private LoginPage loginPage;
	    private MainPage mainPage;
	    private ProductImageControl imageControl;
	    private ProductSelector ProductSelection;
	    private AddToBasket addToBasket;



	
	
	   @BeforeMethod
	    public void initialize(){
	    	
	         loginPage = new LoginPage(driver,wait);
	         mainPage = new MainPage(driver,wait);
	         imageControl = new ProductImageControl(driver,wait);
	         ProductSelection = new ProductSelector(driver,wait);
	         addToBasket = new AddToBasket(driver,wait);

	         


	         
	       
	    }


	@Test(priority=0)
	public void loginTrendyol() throws InterruptedException{
		driver.get("https://www.trendyol.com");
		
	
		Thread.sleep(3000);

		loginPage.closePopup();
		loginPage.accountClick();
		Thread.sleep(3000);

		loginPage.enterEmail();
		Thread.sleep(3000);

		loginPage.submitLogin();
		
		Thread.sleep(3000);

		
		
		/*
		 * ReceiptPage receiptPage = signUpPage.submit();
		 * assertTrue(receiptPage.isInitialized()); assertEquals("Thank you",
		 * receiptPage.confirmationHeader());
		 */
	}
	
	
	   @Test(priority=1)
	    public void ControlAllTabs() throws InterruptedException {
	        
	        mainPage.clickCategoryTabs();

	    }
	   
	   
	   @Test(priority = 2)
	    public void RandomMenuSelectionAndImageControl() throws InterruptedException {

	        imageControl.randomCategory();
	        imageControl.randomTab();

	    }
	   
	   @Test(priority = 3)
	    public void ProductSelection(){

	        ProductSelection.RandomProductSelect();

	    }
	   
	    @Test(priority = 4)
	    public void AddingBasket(){

	        addToBasket.AddProductBasket();

	    }
	   
	   
	
	
	
}