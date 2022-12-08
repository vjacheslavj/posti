package tests;

import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.*;

import static enums.DirectLinks.PARCELS_AND_TRACKING;

public class PostiParcelsAndTrackingTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void postiServicePointsTest() {
        LOGGER.info("This test is doing some actions on Posti parcels and tracking, letters and mails, letter or postcard pages");

        CommonHelpers commonHelpers = new CommonHelpers();
        ServicePointsPage servicePointsPage = new ServicePointsPage(commonHelpers);
        ParcelsAndTrackingPage parcelsAndTrackingPage = new ParcelsAndTrackingPage(commonHelpers);
        LettersAndMailsPage lettersAndMailsPage = new LettersAndMailsPage(commonHelpers);
        SendLetterOrPostcardPage sendLetterOrPostcardPage = new SendLetterOrPostcardPage(commonHelpers);
        LetterPriceCalculatorPage letterPriceCalculatorPage = new LetterPriceCalculatorPage(commonHelpers);

        commonHelpers.openPage(PARCELS_AND_TRACKING.link());
        servicePointsPage.lookingForAcceptCoockieBtn();
        parcelsAndTrackingPage.enterParcelsShippingAddress();
        parcelsAndTrackingPage.validateItemTrackingPage();
        parcelsAndTrackingPage.goBackToParcelsAndTrackingPage();
        parcelsAndTrackingPage.enterWrongParcelsShippingAddress();
        parcelsAndTrackingPage.validateTrackingPageWrongTrackingNr();
        parcelsAndTrackingPage.redirectToLettersAndMailPage();
        lettersAndMailsPage.validateLetterAndMailPage();
        lettersAndMailsPage.redirectToSendLetterPage();
        sendLetterOrPostcardPage.validateSendLetterOrPostcardPage();
        sendLetterOrPostcardPage.clickOnCalculateBtn();
        letterPriceCalculatorPage.validateLetterPriceCalculatorPage();
        letterPriceCalculatorPage.clickOnShowResultBtn();
        commonHelpers.closeBrowser();
    }
}
