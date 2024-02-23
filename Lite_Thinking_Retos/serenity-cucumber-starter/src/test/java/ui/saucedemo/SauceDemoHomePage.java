package ui.saucedemo;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SauceDemoHomePage  extends PageObject {

    public static Target USERNAME = Target.the("username field").locatedBy("#user-name");
    public static Target PASSWORD = Target.the("password field").locatedBy("#password");
    public static Target BUTTONLOGIN = Target.the("login button").locatedBy("#login-button");
   
}
