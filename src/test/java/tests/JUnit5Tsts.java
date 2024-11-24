package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.ScreenshotOnFailureExtension;

import java.io.IOException;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class JUnit5Tsts extends StepsOfTests{
    @Test
    void goUrlTest() throws IOException {
        goToUrl("https://www.hakcanswtest.com");
        scrollToCM();
    }

}