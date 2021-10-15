package seleniumhq.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import seleniumhq.components.HeaderComponent;

public class HomePage extends BasePage<HomePage> {

    @CacheLookup
    @Visible
    private HeaderComponent header;

    // @FindBy(css = "button[data-target='#main_navbar']")
    @FindBy(xpath = "//button[@type='button' and @class='navbar-toggler']")
    private WebElement menuLink;

    public static HomePage open() {
        return PageFactory.newInstance(
            HomePage.class,
            "https://selenium.dev/");
    }

    public HeaderComponent getHeader() {
        // when using Selenium grid, the browser size is smaller and the header is hidden behind this link
        if (menuLink.isDisplayed()) {
            menuLink.click();
        }
        return header;
    }
}
