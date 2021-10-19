package tfl.web.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class JourneyPlannerResultsPage extends BasePage<JourneyPlannerResultsPage> {

    @Visible
    @Name("Results viewport")
    @FindBy(css = ".journey-planner-results")
    private WebElement resultsViewport;

    @Visible
    @Name("Page Title Area")
    //@FindBy(css = "h1 span.jp-results-headline")
    @FindBy(xpath = "//h1//span[@class='jp-results-headline']")
    private WebElement pageTitleArea;

    public String getTitleText() {

        return pageTitleArea.getText();
    }

}
