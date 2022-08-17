package org.example;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


public class OpenBrowserTest extends TestCase {

    public static OpenBrowser openBrowser = new OpenBrowser();
    private static WebDriver driver;

    public void testMain() {
        try{
            Path resourceDirectory = Paths.get("ProjectEnUygun","src","main", "resources");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();
            System.out.println(absolutePath);
            System.setProperty("webdriver.chrome.driver", absolutePath+"\\binary\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String url = "https://demoqa.com/webtables";
            driver.get(url);
            String result;
            WebElement webElement = driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
            result = webElement.getAttribute("placeholder");
            Assert.assertNotNull(webElement);
            Assert.assertEquals(result, "Type to search");
            System.out.println("Test çalıştı");
        }catch (Exception e){
            System.out.println("Driver could not set up!");
        }finally {
            System.out.println("Driver kapatılıyor..");
            driver.close();
        }
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}