package test;

import base.BaseTest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import page.*;

import java.util.Random;

public class HaloOglasiSuccessfulRegistrationTest extends BaseTest {

    HaloOglasiHomePage haloOglasiHomePage;
    HaloOglasiLoginPage haloOglasiLoginPage;
    HaloOglasiRegistrationPage haloOglasiRegistrationPage;
    HaloOglasiSuccessfulRegistrationPage haloOglasiSuccessfulRegistrationPage;
    MailinatorHomePage mailinatorHomePage;
    MailinatorInboxPage mailinatorInboxPage;
    MailinatorHaloOglasiEmailPage mailinatorHaloOglasiEmailPage;
    HaloOglasiUserProfilePage haloOglasiUserProfilePage;

    Random random = new Random();

    String testIme = "nekoTestIme" + random.nextInt(999999);
    String testEmail = testIme + "@mailinator.com";
    String uspesnaRegistracijaMessage = "Registracija je uspela!\n" +
            "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : ";
    String mailinatorUrl = "https://www.mailinator.com/";

    String uspesnaAktivacijaMessage = "Vaš nalog je uspešno aktiviran!\n" +
            "Produžite na stranicu za logovanje kako biste pristupili našem portalu. Prijava";

    String email = "email: ";




    @Before
    public void setUpTest() {
      haloOglasiHomePage = new HaloOglasiHomePage();
      haloOglasiLoginPage = new HaloOglasiLoginPage();
      haloOglasiRegistrationPage = new HaloOglasiRegistrationPage();
      haloOglasiSuccessfulRegistrationPage = new HaloOglasiSuccessfulRegistrationPage();
      mailinatorHomePage = new MailinatorHomePage();
      mailinatorInboxPage = new MailinatorInboxPage();
      mailinatorHaloOglasiEmailPage = new MailinatorHaloOglasiEmailPage();
      haloOglasiUserProfilePage = new HaloOglasiUserProfilePage();
      driver.manage().window().fullscreen();



    }
    @Test
    public void successfulRegistrationTest() {
        haloOglasiHomePage.ulogujSeButtonClick();
        haloOglasiLoginPage.registrujteSeLinkClick();
        haloOglasiRegistrationPage.fizickoLiceRadioButtonAlwaysSelected();
        haloOglasiRegistrationPage.korisnickoImeInputFieldSendKeys(testIme);
        haloOglasiRegistrationPage.emailInputFieldSendKeys(testEmail);
        haloOglasiRegistrationPage.lozinkaInputFieldSendKeys(testIme);
        haloOglasiRegistrationPage.ponoviLozinkuInputFieldSendKeys(testIme);
        haloOglasiRegistrationPage.saglasnostCheckboxClick();
        haloOglasiRegistrationPage.registrujMeButtonClick();
        assertTrue(haloOglasiSuccessfulRegistrationPage.successfulRegistrationMessageIsDisplayed());
        assertEquals(uspesnaRegistracijaMessage + testEmail + " !", haloOglasiSuccessfulRegistrationPage.successfulRegistrationMessageGetText());
        driver.get(mailinatorUrl);
        driver.manage().window().fullscreen();
        mailinatorHomePage.mailinatorInputFieldSendKeys(testEmail);
        mailinatorHomePage.mailinatorInputFieldSendKeyboardKeys(Keys.ENTER);
        mailinatorInboxPage.haloOglasiAktivacioniMailClick();
        mailinatorHaloOglasiEmailPage.switchFocusToIframeBodyWithWdWait();
        mailinatorHaloOglasiEmailPage.aktivirajNalogButtonClick();
        haloOglasiSuccessfulRegistrationPage.switchToNewTab(1);
        assertTrue(haloOglasiSuccessfulRegistrationPage.successfulRegistrationMessageIsDisplayed());
        assertEquals(uspesnaAktivacijaMessage , haloOglasiSuccessfulRegistrationPage.successfulRegistrationMessageGetText());
        haloOglasiSuccessfulRegistrationPage.prijavaLinkClick();
        haloOglasiLoginPage.emailIliKorisnickoImeInputFieldSendKeys(testEmail);
        haloOglasiRegistrationPage.lozinkaInputFieldSendKeys(testIme);
        haloOglasiLoginPage.ulogujMeButtonClick();
        driver.manage().window().fullscreen();
        haloOglasiUserProfilePage.mojProfilDropDownHover();
        assertTrue(haloOglasiUserProfilePage.korisnickoImeIsDisplayed());
        assertEquals(testIme, haloOglasiUserProfilePage.korisnickoImeGetText());
        assertTrue(haloOglasiUserProfilePage.korisnickiEmailIsDisplayed());
        assertEquals(email + testEmail, haloOglasiUserProfilePage.korisnickiEmailGetText());


    }







}
