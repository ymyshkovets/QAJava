package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



public class ForgotPasswordTest {

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
    public void forgotPassword() {

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.openApp();
        forgotPassword.signIn();
        forgotPassword.forgotPasswordLink();
        forgotPassword.emailAddress();
        forgotPassword.retrievePassword();
        String message = forgotPassword.message();
        Assertions.assertEquals("A confirmation email has been sent to your address: test@mail.ru", message);
        forgotPassword.close();
    }


}
