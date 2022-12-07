package tests;

import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.LetterOrPostcardPage;
import pages.LettersAndMailsPage;
import pages.ParcelsAndTrackingPage;
import pages.ServicePointsPage;

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
        LetterOrPostcardPage letterOrPostcardPage = new LetterOrPostcardPage(commonHelpers);

        commonHelpers.openPage(PARCELS_AND_TRACKING.link());
        servicePointsPage.lookingForAcceptCoockieBtn();
        parcelsAndTrackingPage.enterParcelsShippingAddress();
        parcelsAndTrackingPage.validateItemTrackingPage();
        parcelsAndTrackingPage.redirectToLettersAndMailPage();


        commonHelpers.closeBrowser();
    }
}
