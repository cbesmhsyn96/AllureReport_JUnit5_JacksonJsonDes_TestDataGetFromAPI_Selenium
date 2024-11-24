package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.ScreenshotOnFailureExtension;
import utils.SeleniumHelperClass;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class Tests extends SeleniumHelperClass{
    @Test
    void goUrlTest() {
        goToUrl("https://www.hakcanswtest.com");
        scrollToCM();
        assertEquall();
    }

    @Step("Go to hakcan sw test com")
    void goToUrl(String url) {
        gotoUrl(url);
    }

    @Step("Scroll Contact Me section step")
    void scrollToCM() {
        scrollToExistElement();
    }

    @Step("Assert equals Contact Me step")
    void assertEquall() {
        assertEqualByContextOnElement("Contace");
    }

}