package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    //1. Create a new test
    @Test
    public void loginTest() {

        //2. Open a test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3. Assert the browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //4. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal [type='submit']")).click();

        //5. Assert the username in the upper left-hand corner of the screen to check that the user is logged in
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo>span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //6. Assert the browser title...again
        assertEquals(driver.getTitle(), "Home Page");

        //7. Assert that there are 4 items on the header section, they are displayed and ave proper texts
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(menuItems.size(), 4);
        for (WebElement menuItem : menuItems) {
            assertTrue(menuItem.isDisplayed());
        }

        //7. Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        String[] correctTexts = {"To include good practices and ideas from successful EPAM project",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"};

        List<WebElement> textUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        for (WebElement text : textUnderIcons) {
            assertTrue(text.isDisplayed());
        }
        for (int i = 0; i < textUnderIcons.size(); i++) {
            assertEquals(textUnderIcons.get(i).getText().replaceAll("\n", " "), correctTexts[i]);
        }

        //9. Assert the main header text
        String mainTitle = "EPAM FRAMEWORK WISHES…";
        String mainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(driver.findElement(By.cssSelector(".main-title")).getText(), mainTitle);
        assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(), mainText);

        //10. Assert the subheader text
        String subheaderText = "JDI GITHUB";
        WebElement subheader = driver.findElement(By.cssSelector(".text-center > a"));
        assertEquals(subheader.getText(), subheaderText);

        //11. Assert that JDI GITHUB is a link and has a proper URL
        String linkAddress = "https://github.com/epam/JDI";
        assertEquals(subheader.getAttribute("href"), linkAddress);

        //12. Assert that there is a left section
        assertTrue(driver.findElement(By.cssSelector(".uui-side-bar")).isDisplayed());

        //13. Assert that there is a footer
        assertTrue(driver.findElement(By.cssSelector(".footer-content")).isDisplayed());

        //14. Close a browser
        driver.close();
    }
}
