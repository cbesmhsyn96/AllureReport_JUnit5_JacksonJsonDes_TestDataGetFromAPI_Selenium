package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    void testAuthentication() {
        step1();
        step2();
    }

    @Step("Step 1")
    void step1() {
        subStep1();
        subStep2();
    }

    @Step("Sub-step 1")
    void subStep1() {
        Assertions.assertEquals(2,2);
    }

    @Step("Sub-step 2")
    void subStep2() {
        Assertions.assertFalse(false);
    }

    @Step("Step 2")
    void step2() {
        Assertions.assertFalse(false);
    }
}
