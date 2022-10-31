package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ForgotPassword {


    WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.driver = driver;

    }


    public void openApp() {
        driver.get("http://automationpractice.com/index.php");

    }

    public void signIn() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

    }

    public void forgotPasswordLink() {
        driver.findElement(By.xpath("//*[@id='login_form']/div/p[1]/a")).click();
    }

    public void emailAddress() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@mail.ru");
    }

    public void retrievePassword() {
        driver.findElement(By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button/span")).click();
    }

    public String message() {
        String messageExpected = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
        return messageExpected;
    }

    public void close(){
        driver.close();
    }
}
