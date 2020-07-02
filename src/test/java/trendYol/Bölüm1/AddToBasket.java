package trendYol.Bölüm1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToBasket extends BasePage {

    BasePage basePage = new BasePage(driver,wait);

    String cssSelector = "button.pr-in-btn";


    public AddToBasket(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void AddProductBasket(){

        basePage.click(By.cssSelector(cssSelector)); //Adding basket

    }

}
