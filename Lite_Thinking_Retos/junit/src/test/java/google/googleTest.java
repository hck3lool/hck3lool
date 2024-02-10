package google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleTest {

    WebDriver driver;

    @BeforeEach
    public void setupScenario(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void basicSearchGoogle(){
        WebElement campoBuscar = driver.findElement(By.id("APjFqb"));
        campoBuscar.sendKeys("Selenium Web driver");
        WebElement botonBuscar = driver.findElement(By.name("btnK"));
        botonBuscar.click();

        WebElement masPreguntas = driver.findElement(By.className("eJH8qe"));

        assertEquals("Más preguntas", masPreguntas.getText());
        assertEquals("Selenium Web driver - Buscar con Google", driver.getTitle());
    }

    @Test
    public void basicSearchGoogleFormulaOne(){
        WebElement campoBuscar = driver.findElement(By.id("APjFqb"));
        campoBuscar.sendKeys("Formula uno");
        WebElement botonBuscar = driver.findElement(By.name("btnK"));
        botonBuscar.click();

        assertEquals("Formula uno - Buscar con Google", driver.getTitle());
    }

    @AfterEach
    public void cerrarNavegador(){
        driver.quit();
    }
}