package tests;

import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pageLocators.ServicePointsLocators;
import pages.ServicePointsPage;
import utils.Environment;

import static enums.DirectLinks.*;

import static org.junit.jupiter.api.Assertions.*;

public class PostiServicePointsTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void postiServicePointsTest() {
        LOGGER.info("This test is doing some actions on Posti service point page");

        CommonHelpers commonHelpers = new CommonHelpers();
        commonHelpers.openPage(POSTI_SERVICE_POINTS.link());

        ServicePointsPage servicePointsPage = new ServicePointsPage(commonHelpers);
        servicePointsPage.lookingForAcceptCoockieBtn();
        servicePointsPage.chooseMyLocaleAddress();
        servicePointsPage.enterPickupPointsAddress();
        servicePointsPage.zoomInPage();
        servicePointsPage.zoomOutPage();
        servicePointsPage.openFullScreen();
        servicePointsPage.openFullScreen();
        servicePointsPage.findValidateNearestPoints();
        commonHelpers.closeBrowser();
    }
}
