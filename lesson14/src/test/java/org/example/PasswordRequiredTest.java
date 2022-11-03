package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PasswordRequiredTest {

    WebDriver driver;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    @Feature("Password")
    @Description("Verify that password is required")


    public void passwordIsRequired() {

        PasswordRequired passwordRequired = new PasswordRequired(driver);
        passwordRequired.openApp();
        passwordRequired.firstName();
        passwordRequired.lastName();
        passwordRequired.hobby();
        passwordRequired.phoneNumber();
        passwordRequired.username();
        passwordRequired.email();
        passwordRequired.confirmPassword();
        passwordRequired.submitButton();
        String message = passwordRequired.validationMessage();
        Assertions.assertEquals("This field is required.", message);
        passwordRequired.close();

    }
}
