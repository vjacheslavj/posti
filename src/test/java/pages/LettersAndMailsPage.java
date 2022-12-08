package pages;

import constants.Constants;
import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageLocators.LettersAndMailsLocators;

import static org.junit.jupiter.api.Assertions.*;

public class LettersAndMailsPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private CommonHelpers commonHelpers;
    private LettersAndMailsLocators lettersAndMailsLocators = new LettersAndMailsLocators();
    private Constants constants = new Constants();

    public LettersAndMailsPage(CommonHelpers commonHelpers) {
        this.commonHelpers = commonHelpers;
    }

    public void validateLetterAndMailPage() {
        LOGGER.info("Validate that Letter and Mail page title and sections are visible");

        String pageTitle = getLetterAndMailPageTitle();

        assertAll("Some information is not correct",
                () -> assertEquals("Letters and mail", pageTitle, "Letter and mail page title is incorrect"),
                () -> assertTrue(commonHelpers.driver.findElement(lettersAndMailsLocators.SEND_LETTERS_POSTCARD_SECTION).isDisplayed(),
                        "Send a letter or postcard section is not visible"),
                () -> assertTrue(commonHelpers.driver.findElement(lettersAndMailsLocators.MAIL_DELIVERY_SECTION).isDisplayed(),
                        "Mail delivery and change of address section is not visible"));

        for (int i = 0; i <= 6; i++) {
            commonHelpers.waitToBeVisible(lettersAndMailsLocators.LETTERS_AND_MAILS_SECTIONS);
            commonHelpers.waitToBeClickable(lettersAndMailsLocators.LETTERS_AND_MAILS_SECTIONS);
        }
    }

    public String getLetterAndMailPageTitle() {
        LOGGER.info("Looking for the title text on Letter and Mail page");

        commonHelpers.waitToBeVisible(lettersAndMailsLocators.SEND_LETTERS_POSTCARD_SECTION);
        return commonHelpers.driver.findElement(lettersAndMailsLocators.LETTERS_MAILS_PAGE_TITLE).getText();
    }

    public void redirectToSendLetterPage() {
        LOGGER.info("Click on Send Letters or Postcard section");

        commonHelpers.waitToBeVisible(lettersAndMailsLocators.SEND_LETTERS_POSTCARD_SECTION);
        commonHelpers.waitToBeClickable(lettersAndMailsLocators.SEND_LETTERS_POSTCARD_SECTION);
        commonHelpers.click(lettersAndMailsLocators.SEND_LETTERS_POSTCARD_SECTION);
    }
}
