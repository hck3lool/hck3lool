package task.saucedemo;

import models.User;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.saucedemo.SauceDemoHomePage;

public class Autenticate {
    public static Performable login(User user){
        return Task.where(
            "{0} is login in App",
            Enter.theValue(user.getUserName()).into(SauceDemoHomePage.USERNAME),
            Enter.theValue(user.getPassword()).into(SauceDemoHomePage.PASSWORD),
            Click.on(SauceDemoHomePage.BUTTONLOGIN)
        );
    }
}
