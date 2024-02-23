package task.saucedemo;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ShoppingCart {

    public static Performable addElement(WebElementFacade element) {

        return Task.where("{0} adds to shopping cart a product",
            Click.on(element.thenFindAll(".btn").get(0))
        );
    }    
}
