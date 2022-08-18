package pages;

import browsers.BrowserFactory;
import exceptions.BrowserException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import locatorContainers.SignUpPageContainer;
import static org.junit.Assert.assertTrue;

class SignupPageTest {
    private static WebDriver driver;
    public static ChromeOptions options = new ChromeOptions();
    public static SignupPage signupPage;
    @BeforeEach
    void setUp() throws BrowserException {
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.enuygun.com");
        signupPage = new SignupPage();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void openSignupPage() {
        signupPage.openSignupPage(driver);
        boolean signUpButtonIsEnabled = driver.findElement(SignUpPageContainer.signUpButton).isEnabled();
        assertTrue(signUpButtonIsEnabled);
    }
}