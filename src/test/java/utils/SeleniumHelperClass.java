package utils;

import base.Base;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.crypto.spec.OAEPParameterSpec;

public class SeleniumHelperClass extends Base {
    protected static void gotoUrl(String url){
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.get(url);
    }
}
