package pages;

import constants.Constants;
import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageLocators.LetterPriceCalculatorLocators;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetterPriceCalculatorPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private CommonHelpers commonHelpers;
    private LetterPriceCalculatorLocators letterPriceCalculatorLocators = new LetterPriceCalculatorLocators();
    private Constants constants = new Constants();

    public LetterPriceCalculatorPage(CommonHelpers commonHelpers) {
        this.commonHelpers = commonHelpers;
    }

    public void clickOnShowResultBtn() {
        LOGGER.info("Click on Show Result button and validate that two letter options are visible");

        commonHelpers.scrollDownPage();
        commonHelpers.waitToBeVisible(letterPriceCalculatorLocators.SOW_RESULT_BTN);
        commonHelpers.waitToBeClickable(letterPriceCalculatorLocators.SOW_RESULT_BTN);
        commonHelpers.click(letterPriceCalculatorLocators.SOW_RESULT_BTN);

        assertAll("Some information is not correct",
                () -> assertTrue(commonHelpers.driver.findElement(letterPriceCalculatorLocators.INTERNATIONAL_LETTERS_SECTION).isDisplayed(),
                        "International letters section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(letterPriceCalculatorLocators.ECONOMY_LETTERS_SECTION).isDisplayed(),
                        "Economy letters section is not visible"));
    }

    public void validateLetterPriceCalculatorPage() {
        LOGGER.info("Validate that Letter Price calculator page title and sections are visible");

        String pageTitle = getLetterPricePageTitle();

        assertAll("Some information is not correct",
                () -> assertEquals("Letter price calculator", pageTitle, "Letter Price calculator page title is incorrect"),
                () -> assertTrue(commonHelpers.driver.findElement(letterPriceCalculatorLocators.LETTERS_DETAILS_SECTION).isDisplayed(),
                        "Letters details section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(letterPriceCalculatorLocators.INTERNATIONAL_LETTERS_SECTION).isDisplayed(),
                        "International letters section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(letterPriceCalculatorLocators.ECONOMY_LETTERS_SECTION).isDisplayed(),
                        "Economy letters section is not visible"));
    }

    public String getLetterPricePageTitle() {
        LOGGER.info("Looking for the title text on Letter Price calculator page");

        commonHelpers.waitToBeVisible(letterPriceCalculatorLocators.ECONOMY_LETTERS_SECTION);
        return commonHelpers.driver.findElement(letterPriceCalculatorLocators.LETTER_PRICE_PAGE_TITLE).getText();
    }
}