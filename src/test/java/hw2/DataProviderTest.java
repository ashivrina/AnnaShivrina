package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

//This is the test for exercise 1
public class DataProviderTest {

    @DataProvider(parallel = true)
    public Object[][] correctTexts() {
        return new Object[][]{
                {0, "To include good practices and ideas from successful EPAM project"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
    }

    @Test(dataProvider = "correctTexts")
    public void testPageTexts(int textNumber, String s) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        List<WebElement> textUnderIcons = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(textUnderIcons.get(textNumber).getText().replaceAll("\n", " "), s);
        driver.close();
    }


}
