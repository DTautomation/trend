package trendYol.Bölüm1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;

public class MainPage extends BasePage {

    int invalidImageCount = 0; //initialized to count invalid menu images

    BasePage basePage = new BasePage(driver, wait);

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void verifyPageLoaded() { basePage.VerifyFullyLoaded2(driver); }

  
    public void clickCategoryTabs() throws InterruptedException {

        Thread.sleep(3000);
        verifyPageLoaded();
        List<WebElement> linkList = driver.findElements(By.cssSelector("ul.main-nav>li.tab-link>a")); //Lists category tabs


        for (int i = 0; i < linkList.size(); i++) {

            List<WebElement> linkList1 = driver.findElements(By.cssSelector("ul.main-nav>li.tab-link>a")); //Lists category tabs

            linkList1.get(i).click(); // Clicks category tabs one by one
            verifyPageLoaded();//verify page loaded after every category tab click
            System.out.println("Link 0 : " + linkList.get(i));
            Thread.sleep(3000);


            try {

                List<WebElement> imageList = driver.findElements(By.cssSelector(".image-container>img"));//css selector of menu images
                System.out.println("Total image count : " + imageList.size());

                for (WebElement imageElement : imageList) { //takes all menus images one by one
                    if (imageElement != null) { //if image element is not null
                        verifyActiveMenu(imageElement);//calls method that sends request to menu images
                    }
                }

                System.out.println("Total no. of invalid images are " + invalidImageCount);

            }catch (Exception e){

                Reporter.log("Invalid Boutique Image ERR");// if there is an error, error will occur in the test report

            }
        }

    }

    public void verifyActiveMenu(WebElement imageElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imageElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
                        if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            Reporter.log("Boutique Image HTTP ERR");
        }
    }

}
