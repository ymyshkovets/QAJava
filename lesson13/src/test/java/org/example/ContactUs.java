package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;



class ContactUs {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement contactUsLink = driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a"));
        contactUsLink.click();

        WebElement subjectHeading = driver.findElement(By.xpath("//*[@id=\"id_contact\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"message\"]"));
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"submitMessage\"]/span"));

        subjectHeading.click();
        Select selectObject = new Select(subjectHeading);
        selectObject.selectByValue("2");

        email.click();
        email.sendKeys("test@mail.ru");

        message.click();
        message.sendKeys("test");

        sendButton.click();


        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Your message has been successfully sent to our team.";

        Assert.assertEquals(actualMessage, expectedMessage);
        System.out.println("test passed");

        driver.close();


    }
}