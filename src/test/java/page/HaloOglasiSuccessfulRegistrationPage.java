package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiSuccessfulRegistrationPage extends BaseTest {

    public HaloOglasiSuccessfulRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

        @FindBy(className = "regsitration-success")
        WebElement successfulRegistrationMessage;

        public boolean successfulRegistrationMessageIsDisplayed() {
            wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage));
            return successfulRegistrationMessage.isDisplayed();
        }

        public String successfulRegistrationMessageGetText() {
            wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage));
            return successfulRegistrationMessage.getText();
        }









}
