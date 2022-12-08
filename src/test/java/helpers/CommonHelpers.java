package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonHelpers {

    public WebDriver driver;
    public WebDriverWait wait;

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

    public void click2(By locator) {
        LOGGER.info("Clicking on element: " + locator);

        WebElement element = driver.findElement(locator);
        Actions a = new Actions(driver);
        a.moveToElement(element).build().perform();
        a.moveToElement(element).click().build().perform();
    }

    public void moveToElement(By locator) {
        LOGGER.info("Move to element: " + locator);

        WebElement element = driver.findElement(locator);
        Actions a = new Actions(driver);
        a.moveToElement(element).build().perform();
    }

    public void scrollDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
    }

    public void doubleClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions a = new Actions(driver);
        a.moveToElement(element).doubleClick().build().perform();
    }

    public void hover(By locator) {
        WebElement element = driver.findElement(locator);
        Actions a = new Actions(driver);
        a.moveToElement(element).build().perform();

    }


    public void clickEnterText(By locator, String text) {
        LOGGER.info("Waiting then field would be visible, clear it and entering text");

        waitToBeVisible(locator);
        waitToBeClickable(locator);
        waitElementToBeLocated(locator);
        Actions a = new Actions(driver);
        WebElement element = driver.findElement(locator);
        a.moveToElement(element).click().sendKeys(Keys.BACK_SPACE).perform();
        driver.findElement(locator).sendKeys(text);
    }

    public void doubleClickEnterText(By locator, String text) {
        LOGGER.info("Waiting then field would be visible, clear it and entering text");

        waitToBeVisible(locator);
        waitToBeClickable(locator);
        waitElementToBeLocated(locator);
        Actions a = new Actions(driver);
        WebElement element = driver.findElement(locator);
        a.moveToElement(element).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        driver.findElement(locator).sendKeys(text);
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
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

    public void goBackInBrowser() {
        driver.navigate().back();
    }

}
