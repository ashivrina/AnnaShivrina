package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegressionAndSmokeTest {
    @Test(groups = {"regression"})
    public void smokeTestOne() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        driver.close();
    }

    @Test(groups = {"regression"})
    public void smokeTestTwo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        driver.close();
    }

    @Test(groups = {"smoke"})
    public void smokeTestThree() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        driver.close();
    }
}
