package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    public SignupPage() {}

    public void openSignupPage(WebDriver driver) {
        driver.findElement(By.id("ctx-RegisterBtn")).click();
    }


}
