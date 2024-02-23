package questions.google;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class GoogleQuestions{

    public static Question<String> IsUserInResultPage() {
        return Question.about("Is user in result Page")
                   .answeredBy( actor -> BrowseTheWeb.as(actor).getTitle());
    }
    
}
