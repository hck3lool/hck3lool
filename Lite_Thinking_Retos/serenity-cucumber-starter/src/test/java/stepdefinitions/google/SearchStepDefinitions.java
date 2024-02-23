package stepdefinitions.google;

import habilities.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.google.GoogleQuestions;
import task.google.SearchInformation;

public class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(
            NavigateTo.theSearchHomePage("https://www.google.com")
        );
    }

    @When("{actor} searches {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
            SearchInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
            Ensure.that(GoogleQuestions.IsUserInResultPage())
            .contains(term)  
        );
    }
}
