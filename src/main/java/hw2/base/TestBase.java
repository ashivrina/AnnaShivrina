package hw2.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class TestBase {


    @BeforeSuite(alwaysRun = true)
    public void setUpTestSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownTestSuite() {
        System.out.println(System.currentTimeMillis());
    }
}
