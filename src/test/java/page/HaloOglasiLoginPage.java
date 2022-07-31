package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiLoginPage extends BaseTest {
    public HaloOglasiLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Registrujte se →")
    WebElement registrujteSeLink;

    public void registrujteSeLinkClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujteSeLink)).click();
    }
}
