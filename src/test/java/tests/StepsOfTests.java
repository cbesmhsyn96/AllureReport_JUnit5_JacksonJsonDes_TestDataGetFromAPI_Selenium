package tests;

import io.qameta.allure.Step;
import utils.SeleniumHelperClass;

import java.io.IOException;

import static utils.LocatorManager.*;

public class StepsOfTests extends SeleniumHelperClass {
    @Step("Go to hakcan sw test com")
    void goToUrl(String url) {
        gotoUrl(url);
    }

    @Step("Scroll Contact Me section step")
    void scrollToCM() throws IOException {
        scrollToExistElement();
    }

    @Step("Assert equals Contact Me step")
    void assertEquall() throws IOException {
        assertEqualByContextOnElement("Contace");
    }
}
