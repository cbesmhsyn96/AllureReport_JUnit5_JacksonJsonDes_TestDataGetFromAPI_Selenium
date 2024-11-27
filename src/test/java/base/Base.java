package base;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetDataFromApi;
import utils.ManagerTestDatas;

import java.io.File;
import java.io.IOException;

import static utils.AllureScreenshot.*;

public class Base extends ManagerTestDatas {
    public static WebDriver driver;
    public static WebDriverWait wait;
    protected static ChromeOptions options;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    }


    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
