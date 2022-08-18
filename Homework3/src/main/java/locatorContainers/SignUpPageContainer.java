package locatorContainers;

import org.openqa.selenium.By;

public class SignUpPageContainer {
    public static By signUpButton = By.id("ctx-RegisterBtn");
    public static By verifiedSignUpText = By.xpath("//div[text()=\"Enuygun'a Üye Ol\"]");
    public static By signUpEmail = By.cssSelector("input[name='_email']");
    public static By signUpPassword = By.xpath("(//input[@name='_password'])[2]");
    public static By acceptDiscountButton = By.id("_acceptEmails");
    public static By muiSignUpButton = By.xpath("//span[text()='Üye Ol']");
}
