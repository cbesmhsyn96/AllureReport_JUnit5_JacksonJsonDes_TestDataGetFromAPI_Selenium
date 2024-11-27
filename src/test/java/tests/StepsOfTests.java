package tests;

import io.qameta.allure.Step;

import utils.SeleniumHelperClass;

import java.io.IOException;

public class StepsOfTests extends SeleniumHelperClass {
    @Step("Go to website with {url}")
    void goToUrl(String url) {
        gotoUrl(url);
    }

    @Step("Verify that the text of the element with {key} is {content}")
    void elementTextControl(String key, String content) throws IOException {
        assertEqualByContextOnElement(key, content);
    }

    @Step("Click element by {key}")
    void clickElementByKey(String key) throws IOException {
        clickElement(key);
    }

    @Step("If element by {key} click to element")
    void isExistElementClick(String key) throws IOException {
        ifExistClickElement(key);
    }

    @Step("Scroll to element by {key}")
    void scrollToElement(String key) throws IOException {
        scrollToExistElement(key);
    }

    @Step("Verify element by {key} is exist")
    void verifyElementisExist(String key) throws IOException {
         isExistElementByKey(key);
    }

    @Step("Send key {text} to element by {key}")
    void sendKeysElement(String key, String text) throws IOException {
        sendKeysToElement(key,text);
    }

    @Step("Hover element by {key}")
    void hoverElement(String key) throws IOException {
        hoverElementByKey(key);
    }

    @Step("Verify that the attribute name of the element with {key} is {attributeName}")
    void attributeFieldControl(String key,String attributeName) throws IOException {
        attributeFieldControlElementByKey(key,attributeName);
    }

    @Step("Verify that the {attributeName} attribute of the element with {key} has value {valueContext}")
    void attributeValueControl(String key, String attributeName, String valueContext) throws IOException {
        attributeValueControlElementByKey(key,attributeName,valueContext);
    }

    @Step("Click random element from element list by {keyOfListElement}")
    void clickRandomElementFromSameList(String keyOfListElement) throws IOException {
        clickRandomElementFromElementsOnSameList(keyOfListElement);
    }

    @Step("Assert equal current url is {expectedUrl}")
    void assertEqualCurrentUrlisExpected(String expectedUrl){
        assertEqualCurrentUrl(expectedUrl);
    }

    @Step("Assert not equal current url is {expectedUrl}")
    void assertNotEqualCurrentUrlisExpected(String expectedUrl){
        assertEqualCurrentUrl(expectedUrl);
    }

    @Step("Wait and assert equals <text> of element by <key>")
    void waitAndAssertEqualElementText(String text,String key) throws IOException {
        waitForElementWithTestByKey(key,text);
    }

}
