package trendYol.Bölüm1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

	@FindBy(id="accountBtn")
	private WebElement accountButton;
	
	@FindBy(name="email")
	private WebElement email;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(id="loginSubmit")
	private WebElement loginSubmit;
	
	@FindBy(css="a.fancybox-item.fancybox-close")
	private WebElement close;
	
	
    BasePage basepage = new BasePage(driver,wait);

	public LoginPage(WebDriver driver,WebDriverWait wait) {
		super(driver, wait);
	}
	
	

	public boolean isInitialized() {
		return accountButton.isDisplayed();
	}
	
	
	public void closePopup(){
		this.close.click();
	}
	
	public void accountClick(){
		this.accountButton.click();
	}
	
	
	public void enterEmail(){
		this.email.clear();
		this.email.sendKeys("dorukvu@gmail.com");

		this.password.clear();
		this.password.sendKeys("Dreday88");
	}

	public void submitLogin(){
		this.loginSubmit.click();
		
	}
	
	
}