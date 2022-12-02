package pages;

import helpers.CommonHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageLocators.ServicePointsLocators;

public class ServicePointsPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private CommonHelpers commonHelpers;
    private ServicePointsLocators servicePointsLocators = new ServicePointsLocators();

    public ServicePointsPage (CommonHelpers commonHelpers){
        this.commonHelpers = commonHelpers;
    }

    public void lookingForAcceptCoockieBtn() {
        LOGGER.info("Looking for Coockie accept button to click on it");

        commonHelpers.click(servicePointsLocators.COOCKIE_ACCEPT_BTN);
    }

}
