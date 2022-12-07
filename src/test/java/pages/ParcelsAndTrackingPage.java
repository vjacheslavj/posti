package pages;

import constants.Constants;
import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.ParcelsAndTrackingLocators;
import pageLocators.ServicePointsLocators;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelsAndTrackingPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    WebDriverWait wait;

    private CommonHelpers commonHelpers;
    private ParcelsAndTrackingLocators parcelsAndTrackingLocators = new ParcelsAndTrackingLocators();
    private Constants constants = new Constants();

    public ParcelsAndTrackingPage(CommonHelpers commonHelpers) {
        this.commonHelpers = commonHelpers;
    }

    public void enterParcelsShippingAddress() {
        String parcelsNr = constants.PARCEL_SHIPPING_NR;
        LOGGER.info("Find search field and enter parcels shipping number and then click on search button");

        commonHelpers.clickEnterText(parcelsAndTrackingLocators.PARCELS_SEARCH_FIELD, parcelsNr);
        commonHelpers.click(parcelsAndTrackingLocators.PARCELS_SEARCH_BTN);
    }

    public void validateItemTrackingPage() {
        assertAll("Some information is not correct",
                () -> assertTrue(driver.findElement(parcelsAndTrackingLocators.PARCELS_NR).isDisplayed(), "Parcels shipping number is not visible"),
                () -> assertTrue(driver.findElement(parcelsAndTrackingLocators.DELIVERY_STATUS_SECTION).isDisplayed(), "Delivery status section is not visible"),
                () -> assertTrue(driver.findElement(parcelsAndTrackingLocators.ITEM_SIZE_SECTION).isDisplayed(), "Item size section is not visible"),
                () -> assertTrue(driver.findElement(parcelsAndTrackingLocators.RETURN_ITEM_SECTION).isDisplayed(), "Return item section is not visible"),
                () -> assertTrue(driver.findElement(parcelsAndTrackingLocators.TRACKING_STAGES_SECTION).isDisplayed(), "Tracking stage section is not visible"));
    }

    public void redirectToLettersAndMailPage() {
        commonHelpers.waitToBeVisible(parcelsAndTrackingLocators.LETTERS_AND_MAIL_BTN);
        commonHelpers.waitToBeClickable(parcelsAndTrackingLocators.LETTERS_AND_MAIL_BTN);
        commonHelpers.click(parcelsAndTrackingLocators.LETTERS_AND_MAIL_BTN);
    }
}
