package questions.saucedemo;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CheckoutQuestion {

        public static Question<String> resultCheckout() {
        return Question
                    .about("The checkout result")
                    .answeredBy( actor -> BrowseTheWeb.as(actor).textOf(By.id("checkout_complete_container")));
    }
    
}
