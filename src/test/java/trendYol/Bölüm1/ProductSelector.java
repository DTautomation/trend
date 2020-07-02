package trendYol.Bölüm1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductSelector extends BasePage {

    private String xPathAddToBasketButton = "//div[@class='add-to-bs-tx']";

    public ProductSelector(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void RandomProductSelect() {
        click(By.xpath(xPathAddToBasketButton));
    }

    public void chooseSize() {
        try {
            driver.findElement(By.xpath("//div[@class='pr-in-sz-pk']")).click();
            driver.findElement(By.xpath("//div[@class='pr-in-at']//li[1]")).click();
        } catch (Exception ignored) {
        }
    }
}