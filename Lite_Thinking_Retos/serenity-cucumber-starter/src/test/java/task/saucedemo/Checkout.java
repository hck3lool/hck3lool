package task.saucedemo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.saucedemo.SauceDemoStorePage;

public class Checkout {

        public static Performable checkout(){
        return Task.where(
            "{0} checkout the order",
            Click.on(SauceDemoStorePage.SHOPPING_CART),
            Click.on(SauceDemoStorePage.CHECKOUT_BUTTON),
            Enter.theValue("David").into(SauceDemoStorePage.FIRSTNAME_INPUT),
            Enter.theValue("Peña").into(SauceDemoStorePage.LASTNAME_INPUT),
            Enter.theValue("12341234").into(SauceDemoStorePage.POSTALCODE_INPUT),
            Click.on(SauceDemoStorePage.CONTINUE_BUTTON),
            Click.on(SauceDemoStorePage.FINISH_BUTTON)
        );
    }
    
}
