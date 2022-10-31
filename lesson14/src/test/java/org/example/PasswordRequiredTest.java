package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
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
