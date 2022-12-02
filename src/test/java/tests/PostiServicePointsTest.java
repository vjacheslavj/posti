package tests;

import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pageLocators.ServicePointsLocators;
import pages.ServicePointsPage;
import utils.Environment;

import static org.junit.jupiter.api.Assertions.*;

public class PostiServicePointsTest {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void postiServicePointsTest() {
        LOGGER.info("This test is doing some actions on Posti service point page");

        CommonHelpers commonHelpers = new CommonHelpers();
        Environment environment = new Environment();
        commonHelpers.openPage(environment.getUrl());

        ServicePointsPage servicePointsPage = new ServicePointsPage(commonHelpers);
        servicePointsPage.lookingForAcceptCoockieBtn();
    }
}
