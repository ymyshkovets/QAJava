package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidEmail {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[1]/input"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[2]/input"));
        WebElement hobby = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[3]/div/label[1]/input"));
        WebElement phoneHumber = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[6]/input"));
        WebElement username = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[7]/input"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[8]/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[11]/input"));
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[12]/input"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[13]/input"));


        firstName.click();
        firstName.sendKeys("TestName");

        lastName.click();
        lastName.sendKeys("TestLastName");

        hobby.click();

        phoneHumber.click();
        phoneHumber.sendKeys("5584845");

        username.click();
        username.sendKeys("testtest");

        email.click();
        email.sendKeys("test");

        password.click();
        password.sendKeys("123456");


        confirmPassword.click();
        confirmPassword.sendKeys("123456");


        submitButton.click();

        WebElement validationMessage = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[8]/label[2]"));

        if (validationMessage.isEnabled()) {
            System.out.println("test 1 passed");

        } else {
            System.out.println("test 1 failed");
        }

        String actualValidationMessage = validationMessage.getText();
        String expectedValidationMessage = "Please enter a valid email address.";
        Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
        System.out.println("test 2 passed");

        driver.close();

    }
}

