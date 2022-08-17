package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenBrowser {

    public static OpenBrowser openBrowser = new OpenBrowser();
    private static WebDriver driver;

    public static void main(String args[]){

        try{
            Path resourceDirectory = Paths.get("Homework2","src","main");
            String absolutePath = resourceDirectory.toFile().getAbsolutePath();
            System.out.println(absolutePath);
            System.setProperty("webdriver.chrome.driver", absolutePath+"\\resources\\binary\\chromedriver.exe");
            driver = new ChromeDriver();
            String url = "https://demoqa.com/webtables";
            driver.get(url);
            String result;
            WebElement webElement = driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
            result = webElement.getAttribute("placeholder");
        }catch (Exception e){
            System.out.println("Driver could not set up!");
        }finally {
            driver.close();
        }
    }
}
