package github.pages.components;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.PageFactory;
import github.pages.*;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;

@Name("Github Header")
@FindBy(css = "header")
public class HeaderComponent extends HtmlElement {

    @Visible
    @Name("Home Logo/Link")
    // @FindBy(xpath = "//*[name()='svg']//*[local-name()='path']")
    // @FindBy(xpath = "//*[name()='svg' and @class='octicon octicon-mark-github color-text-white']
    @FindBy(xpath = "//a[@href='https://github.com/' and @class='mr-4']")
    private Link homeLink;

    @Name("Search Box")
    @FindBy(xpath = "//input[@name='q'] ")
    private TextInput searchBox;

    @Visible
    @Name("Explore Link")
    // @FindBy(partialLinkText = "Explore")
    @FindBy(xpath = "//summary[contains(text(),'Explore')]")
    private Link exploreLink;

    @Name("Explore Github link")
    @FindBy(xpath = "//a[contains(text(),'Explore GitHub ')]")
    public Link exploreGithubLink;

    @Visible
    @Name("Marketing Sign-Up Banner")
    @FindBy(partialLinkText = "Marketplace")
    private WebElement marketingLink;

    @Step("Go Home")
    public HomePage clickLogo() {
        homeLink.click();
        return PageFactory.newInstance(HomePage.class);
    }

    @Step("Go to the explore page")
    public ExplorePage clickExplore() {
        exploreLink.click();
        return PageFactory.newInstance(ExplorePage.class);
    }

    @Step("Search for the text \"{0}\"")
    public SearchResultsPage search(String searchText) {
        searchBox.sendKeys(searchText + Keys.ENTER);
        return PageFactory.newInstance(SearchResultsPage.class);
    }
}
