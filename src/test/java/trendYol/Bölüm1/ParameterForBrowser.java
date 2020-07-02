package trendYol.Bölüm1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ParameterForBrowser {

	public WebDriver driver;
    public WebDriverWait wait;

    @Parameters("Browser")

    @BeforeClass

    public void browserParameter(String Browser){

        //when you change the browser parameter that located in testNG.xml this method works to open desired browser

        if(Browser.equalsIgnoreCase("ch")){
            driver=new ChromeDriver();
            Reporter.log("Chrome Browser is opened");
            wait=new WebDriverWait(driver,5);
            driver.manage().window().maximize();
            Reporter.log("Chrome Browser is fullscreen");
        }else if(Browser.equalsIgnoreCase("ff")){
            driver=new FirefoxDriver();
            Reporter.log("Firefox Browser is opened");
            wait=new WebDriverWait(driver,5);
            driver.manage().window().maximize();
            Reporter.log("Firefox Browser is fullscreen");
        }else if(Browser.equalsIgnoreCase("ie")){
            driver=new InternetExplorerDriver();
            Reporter.log("Internet Explorer Browser is opened");
            wait=new WebDriverWait(driver,5);
            driver.manage().window().maximize();
            Reporter.log("Internet Explorer Browser is fullscreen");

            }

    }

    @AfterClass
    //Closes the test browser after test cases.
    public void tearDown(){

        driver.quit();

    }

}
