package angularjs.pages.xpath;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.concurrent.TimeUnit;

public class DeveloperGuidePage extends BasePage<DeveloperGuidePage> {

    @Name("Developer guide search")
    @Visible
    @FindBy(xpath = "//input[@name='as_q']")
    private TextInput searchField;

    @Name("Bootstrap link")
    @Visible
    // @FindBy(xpath = "//a[@ng-href='guide/bootstrap' and text()='Bootstrap']")
    // @FindBy(xpath = "//a[@ng-href='guide/bootstrap' and @class='ng-binding']")
    // @FindBy(linkText = "Bootstrap")
    @FindBy(xpath = "//a[text()='Bootstrap']")
    private Link bootstrapSearchItem;

    @Name("Guide article title")
    @FindBy(xpath = "//h1[@class='ng-scope']")
    private WebElement guideTitle;

    @Step("Click search bar")
    public DeveloperGuidePage clickSearchBar() {
        searchField.click();
        return this;
    }

    @Step("Set search bar query text to {0}")
    public DeveloperGuidePage setSearchBar(String inputText) {
        searchField.sendKeys(inputText);
        return this;
    }

    @Step("Click link from search results with title {0}")
    public DeveloperGuidePage clickLinkWithTitle(String linkTitle) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        var searchResultsLink = driver.findElement(
                By.xpath(String.format(
                        "//nav[@id='navbar-main']//a[text()='%s']",
                        linkTitle)));
        wait.until(ExpectedConditions.visibilityOf(searchResultsLink));
        searchResultsLink.click();
        return this;
    }

    @Step("Get developer guide article title")
    public String getGuideTitle(String expectedText) {
        // required to ensure test is more robust i.e. this can't return ""
        wait.until(ExpectedConditions.textToBePresentInElement(guideTitle, expectedText));
        return guideTitle.getText();
    }

}
