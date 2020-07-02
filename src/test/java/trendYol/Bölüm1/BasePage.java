package trendYol.Bölüm1;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {

 

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver,WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;

    }

    public void click(By elementLocation){ 

        driver.findElement(elementLocation).click();

    }

    public void writeText(By elementLocation, String text){ 

        driver.findElement(elementLocation).sendKeys(text);

    }

    public void waitUntilPageContainElements(String elementName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName))); 

    }

    public void VerifyFullyLoaded2(WebDriver driver){ 

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String ready = (String)js.executeScript("return document.readyState");
        System.out.println("Ready or not : "+ready);
    }
    
	
	//Helper class
	
	public WebElement getElement(By byelement, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 48, 2000);
		WebElement element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(byelement));
		return element;

	}
    
    
    
}
  