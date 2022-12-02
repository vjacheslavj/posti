package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowserFactory {

    WebDriver driver;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void setupBrowser() {
        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C://Users/vjermakovs/Desktop/New folder/chromedriver.exe");
        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
    }
}