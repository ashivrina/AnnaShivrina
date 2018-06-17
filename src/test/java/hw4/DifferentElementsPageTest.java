package hw4;

import com.codeborne.selenide.Selenide;
import hw4.base.BaseSelenideClass;
import hw4.enums.ServiceMenuTextsEnum;
import hw4.page_objects.DifferentElementsPage;
import hw4.page_objects.SelenideLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static hw4.enums.DropdownEnum.YELLOW;
import static hw4.enums.RadioButtonsEnum.SELEN;

public class DifferentElementsPageTest extends BaseSelenideClass {

    private SelenideLoginPage loginPage;

    @BeforeClass
    public void setup() {
        loginPage = Selenide.page(SelenideLoginPage.class);
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }

    @Test
    public void elementsPageTest() {

        //1. Open test site by URL
        loginPage.openByUrl();

        //2. Perform login
        loginPage.login("epam", "1234");

        //3. Check username
        loginPage.checkUserName("PITER CHAILOVSKII");

        //4. Check interface on Home page
        loginPage.checkPageInterface();

        //5. Check options in Service menu in header
        loginPage.checkServicesInHeader(ServiceMenuTextsEnum.values());

        //6. Check options in Service menu in sidebar
        loginPage.checkServicesSidebarMenu(ServiceMenuTextsEnum.values());

        //7. Open the Different Elements Page
        DifferentElementsPage differentElementsPage = loginPage.openDifferentElementsPage();

        //8. Check Different Elements Page Interface
        differentElementsPage.checkDifferentElementsPageInterface();

        //9. Select and assert checkboxes
        differentElementsPage.selectCheckboxes();

        //10. Select radiobutton
        differentElementsPage.selectRadiobutton(SELEN);

        //11. Select dropdown
        differentElementsPage.selectDropdownOption(YELLOW);

        //12. Check log for selected values and status
        differentElementsPage.checkLog("Wind", "condition changed to true");
        differentElementsPage.checkLog("Water", "condition changed to true");
        differentElementsPage.checkLog("Selen", "value changed to Selen");
        differentElementsPage.checkLog("Yellow", "value changed to Yellow");

        //13. Unselect and assert checkboxes
        differentElementsPage.deselectCheckboxes();

        //14. Check log for unselected values and status
        differentElementsPage.checkLog("Wind", "condition changed to false");
        differentElementsPage.checkLog("Water", "condition changed to false");

    }
}
