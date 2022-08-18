package locatorContainers;

import org.openqa.selenium.By;

public class LoginPageContainer {
    public static By loginButton = By.id("ctx-LoginBtn");
    public static By verifiedLoginText = By.xpath("//div[text()='Giriş Yap']");
    public static By loginEmail = By.cssSelector("input[name='_email']");
    public static By loginPassword = By.xpath("(//input[@name='_password'])[2]");
    public static By muiLoginButton = By.xpath("//span[text()='Giriş Yap']");
}
