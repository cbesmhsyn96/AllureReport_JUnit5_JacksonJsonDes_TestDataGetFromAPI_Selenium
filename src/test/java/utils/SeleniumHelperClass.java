package utils;

import base.Base;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.crypto.spec.OAEPParameterSpec;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static utils.LocatorManager.*;

public class SeleniumHelperClass extends Base {
    LocatorManager locatorManager;
    private static Actions actions;
    protected static void gotoUrl(String url){
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(url);
    }

    protected static void assertEqualByContextOnElement(String expected) throws IOException {
        assertEquals(expected, findElement("ContactMe_Header").getText());
    }

    protected static void scrollToExistElement() throws IOException {
        actions = new Actions(driver);
        actions.scrollToElement(findElement("ContactMe_Header")).build().perform();
    }

    protected static By getBy(String searchedKey) throws IOException {
        String value = getJsonNode(searchedKey).get("value").asText();
        String type = getJsonNode(searchedKey).get("type").asText();
        switch (type){
            case "css": return By.cssSelector(value);
            case "id": return By.id(value);
            case "xpath": return By.xpath(value);
            case "class": return By.className(value);
        }
        return null;
    }

    protected static WebElement findElement(String searchedKey) throws IOException {
        return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(searchedKey)));
    }

}
