package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class TestHomePage extends StepsOfTests{

    @Order(1)
      //@RepeatedTest(value =  1)
    @Test
    @DisplayName("1. Allthingsdev web sitesine url ile gidilmesi")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("allthingsdev web sitesine https://www.allthingsdev.co/ urli ile gidilmeli.")
    void goWebSiteByUrlTest() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        verifyElementisExist("LoginSignUpButton");
    }

    /*
    Navbarların hepsi link yönlendirmesi yapmadığından hepsi tek tek ele alınıyor.
    Her biri için değil ama Login ve logout durumda iken caseleri de var
     */

    @Order(2)
      //@RepeatedTest(value =  1)
    @Test
    @Disabled
    @DisplayName("2. Navbarda Book Demo linkine tıklanması")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("Navbarda Book Demo linkine tıklanıp AllThingsDev | API Booking Page yazısı görülmeli.")
    void bookDemoNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("BookDemo_NavbarBtn");
        switchToFrameByKey("BookDemoIframe");
        waitAndAssertEqualElementText("AllThingsDev | API Booking Page","BookDemoIframe_Text");
    }

    @Order(3)
      //@RepeatedTest(value =  1)
    @Test
    @DisplayName("3. Navbarda Search linkine tıklanması")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("Navbarda Search linkine tıklanıp Search: yazısı görülmeli.")
    void searchNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("Search_NavbarBtn");
        waitAndAssertEqualElementText("Search:","SearchText");
    }
    @Order(4)
    //@RepeatedTest(value = 1)
    @Test
    @DisplayName("4. Navbarda API Catalogue linkine tıklanması")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("Navbarda Api Catalogue linkine tıklanıp All API Categories yazısı görülmeli.")
    void apiCatalogueNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("APICatalogue_NavbarBtn");
        waitAndAssertEqualElementText("All API Categories","AllAPICategoriesText");
    }

    @Order(5)
    //@RepeatedTest(value = 1)
    @Test
    @DisplayName("5. Navbarda Publisher Dashboard linkine tıklanması")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("Navbarda Publisher Dashbord linkine tıklanıp publisher-dashboard sayfasına gidilmeli")
    void publisherDashbordNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("PublisherDashboard_NavbarBtn");
        waitForURLtoBeTextOfURL("https://www.allthingsdev.co/sign-in?redirectUrl=%2Fpublisher-dashboard");
        verifyElementisExist("EmailTextBox");
        waitAndAssertEqualElementText("Fill your email address and password to sign in.","UnderTestOfWellcomeText");
    }

    @Order(6)
    //@RepeatedTest(value = 1)
    @Test
    @DisplayName("6. Navbarda Blog linkine tıklanması")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("Navbarda blog linkine tıklanıp blog.allthingsdev.co sayfasına gidilmeli")
    void blogNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("Blog_NavbarBtn");
        switchToWindowByIndex(1);
        assertEqualCurrentUrlisExpected("https://blog.allthingsdev.co/");
        waitAndAssertEqualElementText("Discover | Share | Engage","DiscoverShareEngage_Text");
    }

    @Order(7)
    @Test
    @DisplayName("7. Assertion test")
    @Epic("Web UI")
    @Feature("Essential features")
    @Story("Assertion sonucu pass dönmeli. Beklenilen true")
    void assertTest(){
        Assertions.assertTrue(false);
    }
}