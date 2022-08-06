package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class HaloOglasiSuccessfulRegistrationPage extends BaseTest {

    public HaloOglasiSuccessfulRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

        @FindBy(className = "regsitration-success")
        WebElement successfulRegistrationMessage;
        @FindBy(linkText = "Prijava")
        WebElement prijavaLink;

        public boolean successfulRegistrationMessageIsDisplayed() {
            wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage));
            return successfulRegistrationMessage.isDisplayed();
        }

        public String successfulRegistrationMessageGetText() {
            wdWait.until(ExpectedConditions.visibilityOf(successfulRegistrationMessage));
            return successfulRegistrationMessage.getText();
        }

        public void prijavaLinkClick() {
            wdWait.until(ExpectedConditions.elementToBeClickable(prijavaLink)).click();
        }

        public void switchToNewTab(int tab) {
            wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
            ArrayList<String> numberOfTabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(numberOfTabs.get(tab));
        }








}
