package browsers;

import exceptions.BrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    private static WebDriver driver;

    public static WebDriver getBrowser(String browser) throws BrowserException{
        browser = browser.trim();
        if(browser.equals("chrome")){
            driver = new Chrome().createInstance();
        }else if(browser.equals("firefox")){
            driver = new Firefox().createInstance();
        }else{
            throw new BrowserException(browser+"is not supported");
        }
        return driver;
    }


}
