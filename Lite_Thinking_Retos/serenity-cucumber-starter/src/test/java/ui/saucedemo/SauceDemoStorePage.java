package ui.saucedemo;



import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SauceDemoStorePage extends PageObject{

    public static Target ELEMENTSINSTORE = Target.the("Elements in Store").locatedBy(".inventory_item");
    public static Target SHOPPING_CART = Target.the("Shopping cart").locatedBy(".shopping_cart_link");

    public static Target CHECKOUT_BUTTON = Target.the("Checkout Button").located(By.id("checkout"));
    public static Target CONTINUE_BUTTON = Target.the("Continue Button").located(By.id("continue"));
    public static Target FINISH_BUTTON = Target.the("Finish Button").located(By.id("finish"));

    
    public static Target FIRSTNAME_INPUT = Target.the("First name Input").located(By.name("firstName"));
    public static Target LASTNAME_INPUT = Target.the("Last Name input").located(By.id("last-name"));
    public static Target POSTALCODE_INPUT = Target.the("Postal Code input").located(By.id("postal-code"));

}
 