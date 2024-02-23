package stepdefinitions.saucedemo;

import java.util.List;

import habilities.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.saucedemo.CheckoutQuestion;
import task.saucedemo.Autenticate;
import task.saucedemo.Checkout;
import task.saucedemo.ShoppingCart;
import ui.saucedemo.SauceDemoStorePage;

public class CheckoutStepDefinitions {

    @Given("{actor} navigates to the SauceDemo store")
    public void carlota_navigates_to_the_sauce_demo_store(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theSearchHomePage("https://www.saucedemo.com"));
    }

    @Given("{actor} successfully logs in")
    public void carlota_successfully_logs_in(Actor actor) {

        User user = new User("standard_user", "secret_sauce");

        actor.attemptsTo(Autenticate.login(user));
    }

    @When("{actor} adds {int} products to her shopping cart")
    public void she_adds_products_to_her_shopping_cart(Actor actor, Integer productsInteger) {

        List<WebElementFacade> items = SauceDemoStorePage.ELEMENTSINSTORE.resolveAllFor(actor);

        for (int i = 0; i < productsInteger; i++) {

            WebElementFacade selectedItem = items.stream().findAny().orElseThrow();

            actor.attemptsTo(
                ShoppingCart.addElement(selectedItem));
        
            items.remove(selectedItem);
        }

    }

    @When("{actor} proceeds to create a new Checkout")
    public void proceeds_to_create_a_new_checkout(Actor actor) {
        actor.attemptsTo(Checkout.checkout());
    }

    @Then("{actor} will see the Checkout process should be generated accurately")
    public void the_checkout_process_should_be_generated_accurately(Actor actor) {
        actor.attemptsTo(
            Ensure.that(CheckoutQuestion.resultCheckout())
            .contains("Thank you for your order!")
        );
    }

}
