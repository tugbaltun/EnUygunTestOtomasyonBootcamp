package pages;

import browsers.BrowserFactory;
import exceptions.BrowserException;
import locatorContainers.LoginPageContainer;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {

    private static WebDriver driver;
    public static ChromeOptions options = new ChromeOptions();
    private LoginPage loginPage;

    @BeforeEach
    void setUp() throws BrowserException {
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.enuygun.com");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void openLoginPage() {
        driver.findElement(By.id("ctx-LoginBtn")).click();
        boolean loginButtonIsEnabled = driver.findElement(LoginPageContainer.loginButton).isEnabled();
        Assert.assertTrue(loginButtonIsEnabled);
    }
}