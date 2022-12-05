package pages;

import constants.Constants;
import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.ServicePointsLocators;

public class ServicePointsPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    WebDriverWait wait;

    private CommonHelpers commonHelpers;
    private ServicePointsLocators servicePointsLocators = new ServicePointsLocators();
    private Constants constants = new Constants();

    public ServicePointsPage (CommonHelpers commonHelpers){
        this.commonHelpers = commonHelpers;
    }

    String address = constants.PICKUP_POINT_NEAREST_ADDRESS;

    public void lookingForAcceptCoockieBtn() {
        LOGGER.info("Looking for Coockie accept button to click on it");

        commonHelpers.click(servicePointsLocators.COOCKIE_ACCEPT_BTN);
    }

    public void enterPickupPointsAddress() {
        LOGGER.info("Find search field and enter nearest pickup points address and then click on search button");

        commonHelpers.clickEnterText(servicePointsLocators.SEARCH_FIELD, address);
        commonHelpers.click(servicePointsLocators.SEARCH_FIELD);
    }

    public void chooseMyLocaleAddress() {
        LOGGER.info("Choose my locale address and validate that search field is not empty");

        commonHelpers.click(servicePointsLocators.SHARE_YOUR_LOCATION_BTN);
        Assertions.assertTrue(driver.findElement(servicePointsLocators.SEARCH_FIELD).isDisplayed(), "Search field is not empty");
    }

}
