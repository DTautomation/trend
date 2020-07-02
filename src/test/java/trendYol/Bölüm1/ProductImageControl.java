package trendYol.Bölüm1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;
import java.util.Random;

public class ProductImageControl extends BasePage {

    MainPage mainPage = new MainPage(driver,wait);
    BasePage basePage = new BasePage(driver,wait);
    Random random = new Random();
    int invalidImageCount = 0;

    public ProductImageControl (WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void verifyPageLoaded(){ basePage.VerifyFullyLoaded2(driver); }

    public void productImageControl(){ //this method control product images which are located in boutiques

        try {

            List<WebElement> imageList = driver.findElements(By.cssSelector("div.zoom-flow-control>div>img"));
            System.out.println("Total image count : " + imageList.size());

            for (WebElement imageElement : imageList) {
                if (imageElement != null) {
                    verifyActiveProductImages(imageElement);
                }
            }

            System.out.println("Total no. of invalid images are " + invalidImageCount);

        }catch (Exception e){

            Reporter.log("Invalid Product Image Found!");

        }

    }

    public void verifyActiveProductImages(WebElement imageElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imageElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
                     if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            Reporter.log("Product Image HTTP ERR");
        }
    }

    public void randomCategory() throws InterruptedException { //Clicking random category

        Thread.sleep(3000);
        verifyPageLoaded();

        List<WebElement> linkList = driver.findElements(By.cssSelector("ul.main-nav>li.tab-link>a"));

        int linkCount = linkList.size()-1;// counting starts from 0


        int randomLinkClick =  random.nextInt(linkCount);

        System.out.println("random number : "+randomLinkClick);

        linkList.get(randomLinkClick).click();

        verifyPageLoaded();

    }

    public void randomTab() throws InterruptedException { //Clicking random boutique and check all product images that belongs this boutique

        Thread.sleep(3000);

        List<WebElement>butiqueList = driver.findElements(By.cssSelector("span.image-container>img"));

        int butiquecount = butiqueList.size()-1;

        int butiqueRandom = random.nextInt(butiquecount);

        System.out.println("RandomBoutique : "+butiqueRandom);

        butiqueList.get(butiqueRandom).click();

        verifyPageLoaded();

        productImageControl(); //method for product image control

    }

}