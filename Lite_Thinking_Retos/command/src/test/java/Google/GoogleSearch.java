package Google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import utils.Command;

public class GoogleSearch implements Command{

    WebDriver driver;
    String textToFind;

    public GoogleSearch(WebDriver driver, String textToFind) {
        this.driver = driver;
        this.textToFind = textToFind;
    }

    private void textCharactersToFind(){
        driver.findElement(GooglePage.inputTextToSearch).sendKeys(textToFind);
    }

    private void clickSearchButton(){
        driver.findElement(GooglePage.buttonSearch).click();
        driver.findElement(GooglePage.buttonSearch).click();
        driver.findElement(GooglePage.buttonSearch).click();
    }

    public void validateThatThesearchIsCorrect(){
        assertEquals(textToFind + " - Buscar con Google", driver.getTitle());
    }

    public void execute(){
        textCharactersToFind();
        clickSearchButton();
    }
}
