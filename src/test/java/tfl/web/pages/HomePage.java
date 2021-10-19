package tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import com.frameworkium.core.ui.pages.PageFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HomePage extends BasePage<HomePage> {

    @Name("Plan A Journey Link")
    @Visible
    @FindBy(css = "li.plan-journey a")
    private WebElement planJourneyLink;

    @Step("Navigate to the TFL homepage")
    public static AcceptCookiesPage open() {
        // alternative to PageFactory that creates a page object instance with URL
        new HomePage().get("https://tfl.gov.uk");
        return PageFactory.newInstance(AcceptCookiesPage.class);
    }

    @Step("Go to the plan journey page")
    public PlanJourneyPage clickPlanJourneyLink() {
        planJourneyLink.click();
        return PageFactory.newInstance(PlanJourneyPage.class);
    }
}
