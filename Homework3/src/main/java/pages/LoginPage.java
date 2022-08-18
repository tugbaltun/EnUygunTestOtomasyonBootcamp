package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver webDriver){
        driver = webDriver;
    }
    public void openLoginPage(){
        driver.findElement(By.id("ctx-LoginBtn")).click();
    }
}
