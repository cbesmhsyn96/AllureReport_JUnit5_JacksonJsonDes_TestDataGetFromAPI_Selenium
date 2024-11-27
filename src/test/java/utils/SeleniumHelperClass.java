package utils;

import base.Base;

import io.qameta.allure.model.StepResult;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static utils.LocatorManager.*;

public class SeleniumHelperClass extends Base {
    LocatorManager locatorManager;
    private static Random random;
    private static Actions actions;
    protected static void gotoUrl(String url){
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get(url);
    }

    protected static void assertEqualByContextOnElement(String key,String expected) throws IOException {
        assertEquals(expected, findElement(key).getText());
    }

    protected static void clickElement(String key) throws IOException {
        findElement(key).click();
    }

    protected static void isExistElementByKey(String key) throws IOException {
        assertTrue(findElement(key).isDisplayed());
    }

    protected static void assertEqualCurrentUrl(String currentUrl){
        assertEquals(currentUrl,driver.getCurrentUrl());
    }

    protected static void assertNotEqualCurrentUrl(String currentUrl){
        assertNotEquals(currentUrl,driver.getCurrentUrl());
    }

    protected static void waitForElementWithTestByKey(String key, String text) throws IOException {
        assertEquals(text,wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key))).getText());
    }

    protected static void ifExistClickElement(String key) throws IOException {
        if (findElement(key).isDisplayed()){
            findElement(key).click();
        }
    }

    protected static void switchToFrameByKey(String key) throws IOException {
        driver.switchTo().frame(findElement(key));
    }

    protected static void scrollToExistElement(String key) throws IOException {
        actions = new Actions(driver);
        actions.scrollToElement(findElement(key)).build().perform();
    }

    protected static void sendKeysToElement(String key, String text) throws IOException {
        findElement(key).sendKeys(text);
    }

    protected static void hoverElementByKey(String key) throws IOException {
        actions = new Actions(driver);
        actions.moveToElement(findElement(key)).perform();
    }

    protected static void attributeFieldControlElementByKey(String key,String attributeField) throws IOException {
        assertNotNull(findElement(key).getAttribute(attributeField));
    }

    protected static void attributeValueControlElementByKey(String key,String attributeField, String expectedValue) throws IOException {
        Assertions.assertTrue(findElement(key).getAttribute(attributeField).contains(expectedValue));
    }

    protected static void clickRandomElementFromElementsOnSameList(String elementListKey) throws IOException {
        random = new Random();
        List<WebElement> elementList = findElements(elementListKey);
        elementList.get(random.nextInt(elementList.size())).click();
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

    protected static List<WebElement> findElements(String listElementKey) throws IOException {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getBy(listElementKey)));
    }

}