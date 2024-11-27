package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

public class TestHomePage extends StepsOfTests{

    @Order(1)
    @RepeatedTest(value =  5)
    @DisplayName("1. test Allthingsdev web sitesine url ile gidilmesi")
    void goWebSiteByUrlTest() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        verifyElementisExist("LoginSignUpButton");
    }

    /*
    Navbarların hepsi link yönlendirmesi yapmadığından hepsi tek tek ele alınıyor.
    Her biri için değil ama Login ve logout durumda iken caseleri de var.
     */

    @Order(2)
    @RepeatedTest(value =  5)
    @DisplayName("2. test Navbarda Book Demo linkine tıklanması")
    void bookDemoNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("BookDemo_NavbarBtn");
        switchToFrameByKey("BookDemoIframe");
        waitAndAssertEqualElementText("AllThingsDev | API Booking Page","BookDemoIframe_Text");
    }

    @Order(3)
    @RepeatedTest(value =  5)
    @DisplayName("3. test Navbarda Search linkine tıklanması")
    void searchNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("Search_NavbarBtn");
        waitAndAssertEqualElementText("Search:","SearchText");
    }

    @Order(4)
    @RepeatedTest(value = 5)
    @DisplayName("4. test Navbarda API Catalogue linkine tıklanması")
    void apiCatalogueNavbarLinkClick() throws IOException {
        goToUrl("https://www.allthingsdev.co/");
        clickElementByKey("APICatalogue_NavbarBtn");
        waitAndAssertEqualElementText("All API Categories","AllAPICategoriesText");
    }


}