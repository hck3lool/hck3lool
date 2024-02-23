package habilities;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    
    public static Performable theSearchHomePage(String urlString) {
        return Task.where(
            "{0} opens " + urlString + " page",
            Open.url(urlString));
    }
}
