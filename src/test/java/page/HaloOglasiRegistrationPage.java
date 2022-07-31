package page;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiRegistrationPage extends BaseTest {

    public HaloOglasiRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value=\"person\"]")
    WebElement fizickoLiceRadioButton;
    @FindBy(id = "UserName")
    WebElement korisnickoImeInputField;
    @FindBy(id = "Email")
    WebElement emailInputField;
    @FindBy(id = "Password")
    WebElement lozinkaInputField;
    @FindBy(id = "ConfirmPassword")
    WebElement ponoviLozinkuInputField;
    @FindBy(id = "HasAgreedToGetFiscalReceiptByEmail")
    WebElement saglasnostCheckbox;
    @FindBy(css = ".buttons-wrapper > button:first-child")
    WebElement registrujMeButton;

    public void fizickoLiceRadioButtonAlwaysSelected() {
        wdWait.until(ExpectedConditions.elementToBeClickable(fizickoLiceRadioButton));
        if (!fizickoLiceRadioButton.isSelected())
            fizickoLiceRadioButton.click();

    }
    public void korisnickoImeInputFieldSendKeys(String ime) {
        wdWait.until(ExpectedConditions.visibilityOf(korisnickoImeInputField)).clear();
        korisnickoImeInputField.sendKeys(ime);
    }
    public void emailInputFieldSendKeys(String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }
    public void lozinkaInputFieldSendKeys(String lozinka) {
        wdWait.until(ExpectedConditions.visibilityOf(lozinkaInputField)).clear();
        lozinkaInputField.sendKeys(lozinka);
    }

    public void ponoviLozinkuInputFieldSendKeys(String ponoviLozinku) {
        wdWait.until(ExpectedConditions.visibilityOf(ponoviLozinkuInputField)).clear();
        ponoviLozinkuInputField.sendKeys(ponoviLozinku);
    }

    public void saglasnostCheckboxClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(saglasnostCheckbox)).click();
    }

    public void registrujMeButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujMeButton)).click();
    }




}
