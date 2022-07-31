package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.HaloOglasiHomePage;
import page.HaloOglasiLoginPage;
import page.HaloOglasiRegistrationPage;
import page.HaloOglasiSuccessfulRegistrationPage;

public class HaloOglasiSuccessfulRegistrationTest extends BaseTest {

    HaloOglasiHomePage haloOglasiHomePage;
    HaloOglasiLoginPage haloOglasiLoginPage;
    HaloOglasiRegistrationPage haloOglasiRegistrationPage;
    HaloOglasiSuccessfulRegistrationPage haloOglasiSuccessfulRegistrationPage;

    @Before
    public void setUpTest() {
      haloOglasiHomePage = new HaloOglasiHomePage();
      haloOglasiLoginPage = new HaloOglasiLoginPage();
      haloOglasiRegistrationPage = new HaloOglasiRegistrationPage();
      haloOglasiSuccessfulRegistrationPage = new HaloOglasiSuccessfulRegistrationPage();
    }
    @Test
    public void successfulRegistrationTest() {
        haloOglasiHomePage.ulogujSeButtonClick();
        haloOglasiLoginPage.registrujteSeLinkClick();
        haloOglasiRegistrationPage.fizickoLiceRadioButtonAlwaysSelected();
        haloOglasiRegistrationPage.korisnickoImeInputFieldSendKeys("nekotestime34");
        haloOglasiRegistrationPage.emailInputFieldSendKeys("nekotestime34@emailinator.com");
        haloOglasiRegistrationPage.lozinkaInputFieldSendKeys("12345678");
        haloOglasiRegistrationPage.ponoviLozinkuInputFieldSendKeys("12345678");
        haloOglasiRegistrationPage.saglasnostCheckboxClick();
        haloOglasiRegistrationPage.registrujMeButtonClick();
        Assert.assertTrue(haloOglasiSuccessfulRegistrationPage.successfulRegistrationMessageIsDisplayed());
        Assert.assertEquals("Registracija je uspela!\n" +
                "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : nekotestime34@emailinator.com !", haloOglasiSuccessfulRegistrationPage.successfulRegistrationMessageGetText());

    }







}
