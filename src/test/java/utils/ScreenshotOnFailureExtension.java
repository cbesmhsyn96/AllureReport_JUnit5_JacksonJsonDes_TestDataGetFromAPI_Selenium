package utils;

import base.Base;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ScreenshotOnFailureExtension extends Base implements AfterTestExecutionCallback{

    @Override
    public void afterTestExecution(ExtensionContext context) {
        boolean testFailed = context.getExecutionException().isPresent();
        if (testFailed) {
            String testName = context.getTestMethod().map(method -> method.getName()).orElse("unknown");
            String screenshotPath = AllureScreenshot.attachScreenshot(driver, testName);

            // Allure'a ekran görüntüsünü ekle
            try {
                Allure.addAttachment("Screenshot", new FileInputStream(screenshotPath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

