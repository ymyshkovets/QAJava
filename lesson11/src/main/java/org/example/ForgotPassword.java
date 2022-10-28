package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ForgotPassword {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));

        signInLink.click();

        WebElement forgetPassword = driver.findElement(By.xpath("//*[@id='login_form']/div/p[1]/a"));

        forgetPassword.click();
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailAddress.click();
        emailAddress.sendKeys("test@mail.ru");

        WebElement retrievPasword = driver.findElement(By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button/span"));
        retrievPasword.click();


        WebElement message = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
        String actualMessage = message.getText();
        String expectedMessage = "A confirmation email has been sent to your address: test@mail.ru";

        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("test passed");

        driver.close();

    }

}