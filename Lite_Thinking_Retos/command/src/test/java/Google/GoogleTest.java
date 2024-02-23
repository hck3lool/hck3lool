package Google;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void googleSearch(){
        GoogleSearch googleSearch = new GoogleSearch(driver, "Selena Gomez");
        googleSearch.execute();
        googleSearch.validateThatThesearchIsCorrect();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
