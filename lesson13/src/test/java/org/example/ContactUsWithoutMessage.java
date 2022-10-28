package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


class ContactUsWithoutMessage {

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


        sendButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "There is 1 error";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("test 1 passed");


        WebElement validationMessage = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        String actualValidationMessage = validationMessage.getText();
        String expectedValidationMessage = "The message cannot be blank.";

        Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
        System.out.println("test 2 passed");

        driver.close();


    }
}