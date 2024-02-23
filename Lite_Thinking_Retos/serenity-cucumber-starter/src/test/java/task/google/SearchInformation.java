package task.google;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import ui.google.GoogleHomePage;

import org.openqa.selenium.Keys;

public class SearchInformation {
    public static Performable about(String searchTerm) {
        return Task.where(
                "{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                    .into(GoogleHomePage.SEARCH_FIELD)
                    .thenHit(Keys.ENTER));
    }
}
