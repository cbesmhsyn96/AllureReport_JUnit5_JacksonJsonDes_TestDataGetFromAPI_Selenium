package base;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

@ExtendWith(Base.TestResultWatcher.class)
public class Base{
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ChromeOptions options;
    private static final AllureLifecycle LIFECYCLE = Allure.getLifecycle();
    private static boolean lastTestResult;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    }

    @AfterEach
    public void tearDown(){
        if (!lastTestResult){
            captureScreenshot(driver);
        }
        driver.quit();
    }

    @Attachment(value = "Screenshot", type = "image/jpg")
    public byte[] captureScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public static class TestResultWatcher implements TestWatcher {
        @Override
        public void testSuccessful(org.junit.jupiter.api.extension.ExtensionContext context) {
            Base.lastTestResult = true; // Test başarılı
        }

        @Override
        public void testFailed(org.junit.jupiter.api.extension.ExtensionContext context, Throwable cause) {
            Base.lastTestResult = false; // Test başarısız
        }

        @Override
        public void testAborted(org.junit.jupiter.api.extension.ExtensionContext context, Throwable cause) {
            Base.lastTestResult = false; // İptal edilmiş gibi düşünebilirsiniz
        }
    }
}
