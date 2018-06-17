package hw4.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.ServiceMenuTextsEnum;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideLoginPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo>span")
    private SelenideElement username;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsUnderImages;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection images;

    @FindBy(css = ".main-title.text-center")
    private SelenideElement header;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement subheader;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 .dropdown")
    private SelenideElement serviceButtonHeader;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 .dropdown li")
    private ElementsCollection serviceMenuOptionsHeader;

    @FindBy(css = ".sidebar-menu li.active > a > span")
    private SelenideElement serviceButtonSidebar;

    @FindBy(css = ".sidebar-menu .sub li")
    private ElementsCollection serviceMenuOptionsSidebar;


    public void openByUrl() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void checkTitle(String title) {
        $("title").shouldHave(text(title));
    }

    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserName(String name) {
        username.shouldHave(visible, text(name));
    }

    public void checkPageInterface() {
        header.shouldBe(visible);
        subheader.shouldBe(visible);
        images.shouldHaveSize(4);
        textsUnderImages.shouldHaveSize(4);
    }

    public void checkServicesInHeader(ServiceMenuTextsEnum[] options) {
        String[] optionsTitles = new String[8];
        for (int i = 0; i < options.length; i++) {
            optionsTitles[i] = options[i].text;
        }
        serviceButtonHeader.click();
        serviceMenuOptionsHeader.shouldHave(texts(optionsTitles));
    }

    public void checkServicesSidebarMenu(ServiceMenuTextsEnum[] options) {
        String[] optionsTitles = new String[8];
        for (int i = 0; i < options.length; i++) {
            optionsTitles[i] = options[i].text;
        }
        serviceButtonSidebar.click();
        serviceMenuOptionsSidebar.shouldHave(texts(optionsTitles));
    }

    public DifferentElementsPage openDifferentElementsPage() {
        serviceButtonHeader.click();
        serviceMenuOptionsHeader.get(6).click();
        return page(DifferentElementsPage.class);
    }
}
