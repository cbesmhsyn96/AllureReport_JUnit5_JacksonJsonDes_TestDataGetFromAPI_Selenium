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
    void goUrlTest() throws IOException {
        goToUrl("");
    }

}