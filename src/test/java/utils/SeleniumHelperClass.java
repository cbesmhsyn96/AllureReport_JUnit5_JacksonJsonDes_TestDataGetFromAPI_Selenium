package utils;

import base.Base;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.crypto.spec.OAEPParameterSpec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SeleniumHelperClass extends Base {
    private static Actions actions;
    protected static void gotoUrl(String url){
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    protected static void assertEqualByContextOnElement(String expected){
        assertEquals(expected,driver.findElement(By.cssSelector("#contact > div > h1")).getText());
    }

    protected static void scrollToExistElement(){
        actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.cssSelector("#contact > div > h1"))).build().perform();
    }


}
