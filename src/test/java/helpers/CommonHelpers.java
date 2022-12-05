package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserFactory;

public class CommonHelpers {
    BrowserFactory browserFactory = new BrowserFactory();

    WebDriver driver;
    WebDriverWait wait;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public CommonHelpers() {
        LOGGER.info("Setting driver location");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\Proj\\chromedriver\\chromedriver108.exe");
        LOGGER.info("Opening browser window");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String url) {
        LOGGER.info("Opening page by URL: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        driver.get(url);
    }

    public void click(By locator) {
        LOGGER.info("Clicking on element: " + locator);

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }


    public void clickEnterText(By locator, String text) {
        LOGGER.info("Waiting then field would be visible, clear it and entering text");

        waitToBeVisible(locator);
        waitToBeClickable(locator);
        waitElementToBeLocated(locator);
        sleep();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }


    public void waitToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementToBeLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getSearchFieldText(By locator) {
        LOGGER.info("Looking for the value of search field");

        return driver.findElement(locator).getAttribute("value");
    }

    public void closeBrowser() {
        driver.close();
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }

}
