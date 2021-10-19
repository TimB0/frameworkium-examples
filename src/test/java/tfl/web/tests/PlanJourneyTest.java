package tfl.web.tests;

import com.frameworkium.core.ui.tests.BaseUITest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import tfl.web.pages.HomePage;

import static com.google.common.truth.Truth.assertThat;

public class PlanJourneyTest extends BaseUITest {

    @TmsLink("TFL-1")
    @Test
    public final void planJourneyTest() {

        var planJourneyPage = HomePage
                .open()
                .clickAcceptAllCookiesBtn()
                .clickAcceptCookiesDoneBtn()
                .clickPlanJourneyLink();

        // Plan a journey between two locations
        var resultsPage = planJourneyPage
                .planJourney("Clapham Junction", "Oxford Circus Underground Station");

        // Check that the title displayed on the page is "Journey results"
        assertThat(resultsPage.getTitleText()).isEqualTo("Journey results");
    }
}
