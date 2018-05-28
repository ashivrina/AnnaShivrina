package hw3;


import hw3.base.TestBase;
import hw3.enums.IndexPageTextsEnum;
import hw3.enums.MenuOptionsTextsEnum;
import hw3.page_objects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {

    private LoginPage loginPage;

    @BeforeClass
    public void setUpPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginTest() {
        //1 Open website by URL
        loginPage.open(driver);

        //2 Assert Browser title
        loginPage.checkPageTitle(driver, "Home Page");

        //3 Perform login
        loginPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is logged in
        loginPage.checkUsername("PITER CHAILOVSKII");

        //5 Assert Browser title...again
        loginPage.checkPageTitle(driver, "Home Page");

        //6. Assert that there are 4 items on the header section, they are displayed and ave proper texts
        loginPage.checkMenuOptions(MenuOptionsTextsEnum.values());

        //7. Assert that there are 4 images on the Home Page and they are displayed
        loginPage.checkImages();

        //8. Assert that there are 4 texts on the Home Page and check them by getting texts
        loginPage.checkTextsUnderImages(IndexPageTextsEnum.values());

        //9. Assert that there are the main header and the text below it on the Home Page
        loginPage.checkHeaderDisplayed();
        loginPage.checkSubheaderDisplayed();

        //10. Assert that JDI GITHUB is a link and has a proper URL
        loginPage.checkSubheaderUrl("https://github.com/epam/JDI");

        //11. Assert that there is a left section
        loginPage.checkLeftMenuDisplayed();

        //12. Assert that there is a footer
        loginPage.checkFooterDisplayed();

    }
}
