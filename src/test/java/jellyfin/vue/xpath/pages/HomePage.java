package jellyfin.vue.xpath.pages;

import com.frameworkium.core.ui.UITestLifecycle;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage<HomePage> {

    @Name("Add Server Field")
    @Visible
    @FindBy(xpath = "//label[text()='Server address']")
    private WebElement addServerField;

    @Step("Open home page")
    public static HomePage open() {
        UITestLifecycle.get().getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return PageFactory.newInstance(HomePage.class, "https://jellyfin-vue.pages.dev/server/add");
    }

    @Step("Click Add Server Field")
    public HomePage clickAddServerField() {
        addServerField.click();
        return this;
    }
}
