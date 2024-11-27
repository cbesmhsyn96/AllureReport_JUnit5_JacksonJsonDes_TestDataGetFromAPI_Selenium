package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.ScreenshotOnFailureExtension;

import java.io.IOException;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class TestHomePage extends StepsOfTests{
    @Test
    @DisplayName("Allthingsdev web sitesine url ile gidilmesi")
    void goWebSiteByUrlTest() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        verifyElementisExist("LoginSignUpButton");
    }

    /*
    Navbarların hepsi link yönlendirmesi yapmadığından hepsi tek tek ele alınıyor.
    Her biri için değil ama Login ve logout durumda iken caseleri de var.
     */

    @Test
    @DisplayName("Navbarda Book Demo linkine tıklanması")
    void bookDemoNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("BookDemo_NavbarBtn");
        switchToFrameByKey("BookDemoIframe");
        waitAndAssertEqualElementText("AllThingsDev | API Booking Page","BookDemoIframe_Text");
    }




}