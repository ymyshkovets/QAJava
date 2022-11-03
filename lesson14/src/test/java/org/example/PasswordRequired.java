package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordRequired {

    WebDriver driver;

    public PasswordRequired(WebDriver driver) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.driver = driver;


    }

    public void openApp() {
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

    }

    public void firstName() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[1]/input")).sendKeys("test");

    }

    public void lastName() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[2]/input")).sendKeys("test");

    }

    public void hobby() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[3]/div/label[1]/input")).click();

    }

    public void phoneNumber() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[6]/input")).sendKeys("5554411");

    }

    public void username() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[7]/input")).sendKeys("tester");

    }


    public void email() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[8]/input")).sendKeys("test@mail.ru");

    }

    public void confirmPassword() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[12]/input")).sendKeys("6986");

    }

    public void submitButton() {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[13]/input")).click();

    }

    public String validationMessage() {
        String messageExpected = driver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[11]/label[2]")).getText();
        return messageExpected;
    }

    public void close() {
        driver.close();
    }


}





