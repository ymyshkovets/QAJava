package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.Random;


//Invalid: Sign in with unexisting user

public class SignIn {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\учеба\\Andersen JAVA\\Проекты\\дз 11.2\\lesson11\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();


        WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));


        signInLink.click();

        WebElement emailAddress = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailAddress.click();

        emailAddress.sendKeys("name" + randomInt + "@mail.ru");

        password.click();
        password.sendKeys("123456");

        signInButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
        WebElement validationMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "There is 1 error";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("test 1 passed");

        String actualValidationMessage = validationMessage.getText();
        String expectedValidationMessage = "Authentication failed.";
        Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
        System.out.println("test 2 passed");

        driver.close();


    }
}
