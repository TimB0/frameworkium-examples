package tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class AcceptCookiesPage extends BasePage<AcceptCookiesPage> {

    @Name("Accept all cookies button")
    @Visible
    @FindBy(xpath = "//button[@onclick='acceptAllCookies(); return false;']")
    private WebElement acceptAllCookiesBtn;

    @Name("Accept cookies done button")
    @FindBy(xpath = "//button[@onclick='endCookieProcess(); return false;']")
    private WebElement acceptCookiesDoneBtn;

    @Step("Accept all cookies")
    public AcceptCookiesPage clickAcceptAllCookiesBtn() {
        acceptAllCookiesBtn.click();
        return this;
    }

    @Step("Click accept cookies Done btn")
    public HomePage clickAcceptCookiesDoneBtn() {
        acceptCookiesDoneBtn.click();
        return PageFactory.newInstance(HomePage.class);
    }
}
