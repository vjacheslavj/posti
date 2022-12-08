package pages;

import constants.Constants;
import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageLocators.ParcelsAndTrackingLocators;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelsAndTrackingPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

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

    public void enterWrongParcelsShippingAddress() {
        String wrongParcelsNr = constants.WRONG_PARCEL_SHIPPING_NR;
        LOGGER.info("Find search field and enter wrong parcels shipping number and then click on search button");

        commonHelpers.clickEnterText(parcelsAndTrackingLocators.PARCELS_SEARCH_FIELD, wrongParcelsNr);
        commonHelpers.click(parcelsAndTrackingLocators.PARCELS_SEARCH_BTN);
    }

    public void validateTrackingPageWrongTrackingNr() {
        LOGGER.info("Validate Item tracking page with wrong parcel shipping number");

        String expectedText = "No items could be found based on the tracking code.";
        String actualText = getNoItemText();
        assertEquals(expectedText, actualText, "Tracking page text for the wrong tracking number is incorrect");

    }

    public String getNoItemText() {
        LOGGER.info("Looking for the no item could be found text on Item tracking page");
        commonHelpers.waitToBeVisible(parcelsAndTrackingLocators.NO_ITEM_COULD_BE_FOUND);
        return commonHelpers.driver.findElement(parcelsAndTrackingLocators.NO_ITEM_COULD_BE_FOUND).getText();
    }

    public void validateItemTrackingPage() {
        LOGGER.info("Validate Item tracking page");

        String pageTitle = getItemTrackingPageTitle();

        assertAll("Some information is not correct",
                () -> assertEquals("Item Tracking", pageTitle, "Item Tracking page title is incorrect"),
                () -> assertTrue(commonHelpers.driver.findElement(parcelsAndTrackingLocators.PARCELS_NR).isDisplayed(), "Parcels shipping number is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(parcelsAndTrackingLocators.DELIVERY_STATUS_SECTION).isDisplayed(), "Delivery status section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(parcelsAndTrackingLocators.ITEM_SIZE_SECTION).isDisplayed(), "Item size section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(parcelsAndTrackingLocators.RETURN_ITEM_SECTION).isDisplayed(), "Return item section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(parcelsAndTrackingLocators.TRACKING_STAGES_SECTION).isDisplayed(), "Tracking stage section is not visible"));
    }

    public String getItemTrackingPageTitle() {
        LOGGER.info("Looking for the title text on Item tracking page");

        commonHelpers.waitToBeVisible(parcelsAndTrackingLocators.TRACKING_STAGES_SECTION);
        return commonHelpers.driver.findElement(parcelsAndTrackingLocators.PARCELS_TRACKING_PAGE_TITLE).getText();
    }

    public void goBackToParcelsAndTrackingPage() {
        LOGGER.info("Going back to the Parcels and Tracking page");

        commonHelpers.goBackInBrowser();
    }

    public void redirectToLettersAndMailPage() {
        LOGGER.info("Click on Letters and Mail section");

        commonHelpers.waitToBeVisible(parcelsAndTrackingLocators.LETTERS_AND_MAIL_BTN);
        commonHelpers.waitToBeClickable(parcelsAndTrackingLocators.LETTERS_AND_MAIL_BTN);
        commonHelpers.click(parcelsAndTrackingLocators.LETTERS_AND_MAIL_BTN);
    }
}
