package pages;

import constants.Constants;
import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageLocators.SendLetterOrPostcardLocators;

import static org.junit.jupiter.api.Assertions.*;
public class SendLetterOrPostcardPage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private CommonHelpers commonHelpers;
    private SendLetterOrPostcardLocators sendLetterOrPostcardLocators = new SendLetterOrPostcardLocators();
    private Constants constants = new Constants();

    public SendLetterOrPostcardPage(CommonHelpers commonHelpers) {
        this.commonHelpers = commonHelpers;
    }

    public void validateSendLetterOrPostcardPage() {
        LOGGER.info("Validate Send a Letter or postcard page");

        String pageTitle = getSendLettersOrPostcardPageTitle();

        assertAll("Some information is not correct",
                () -> assertEquals("Send a letter or postcard", pageTitle, "Letter and mail page title is incorrect"),
                () -> assertTrue(commonHelpers.driver.findElement(sendLetterOrPostcardLocators.DOMESTIC_LETTERS_BLOCK).isDisplayed(), "Domestic letters block is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(sendLetterOrPostcardLocators.ADDITIONAL_QUESTIONS_BLOCK).isDisplayed(), "Additional questions block is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(sendLetterOrPostcardLocators.DESIGN_POSTCARD_BLOCK).isDisplayed(), "Design postcard block is not visible"));
    }

    public String getSendLettersOrPostcardPageTitle() {
        LOGGER.info("Looking for the Title text on Send Letters or postcard page");

        commonHelpers.waitToBeVisible(sendLetterOrPostcardLocators.CALCULATE_PRICE_BTN);
        commonHelpers.waitToBeVisible(sendLetterOrPostcardLocators.DOMESTIC_LETTERS_BLOCK);
        commonHelpers.waitToBeVisible(sendLetterOrPostcardLocators.DESIGN_POSTCARD_BLOCK);
        return commonHelpers.driver.findElement(sendLetterOrPostcardLocators.SEND_LETTER_PAGE_TITLE).getText();
    }

    public void clickOnCalculateBtn() {
        LOGGER.info("Click on calculate the price and send button");

        commonHelpers.waitToBeVisible(sendLetterOrPostcardLocators.CALCULATE_PRICE_BTN);
        commonHelpers.waitToBeClickable(sendLetterOrPostcardLocators.CALCULATE_PRICE_BTN);
        commonHelpers.click(sendLetterOrPostcardLocators.CALCULATE_PRICE_BTN);
    }
}
