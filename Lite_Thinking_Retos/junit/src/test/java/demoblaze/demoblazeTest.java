package demoblaze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoblazeTest {

    WebDriver driver;

    @BeforeEach
    public void abrirPagina(){
        driver = new ChromeDriver();
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void obtenerValorHTCONEM9(){
        //primer articulo
        WebElement phones = driver.findElement(By.xpath("//*[@id='itemc'][1]"));
        phones.click();
        WebElement hTCOne_M9 = driver.findElement(By.xpath("//a[contains(., 'HTC One M9')]"));
        hTCOne_M9.click();
        WebElement hTCOne_M9Precio = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"));
        System.out.println("El precio del HTC One M9 es: " + hTCOne_M9Precio.getText());

        WebElement informacionDetallada = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        assertEquals("HTC One M9", informacionDetallada.getText());
    }

    @Test
    public void obtenerValorMacBookAir(){
        //segundo articulo
        WebElement laptops = driver.findElement(By.xpath("//*[@id='itemc'][2]"));
        laptops.click();
        WebElement macBook_Air = driver.findElement(By.xpath("//a[contains(., 'MacBook air')]"));
        macBook_Air.click();
        WebElement macBook_AirPrecio = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"));
        System.out.println("El precio de la Mac Book Air es: " + macBook_AirPrecio.getText());

        WebElement informacionDetallada = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        assertEquals("MacBook air", informacionDetallada.getText());
    }

    @Test
    public void obtenerValorMacBookPro(){
        //tercer articulo
        WebElement laptops = driver.findElement(By.xpath("//*[@id='itemc'][2]"));
        laptops.click();
        WebElement macBook_Air = driver.findElement(By.xpath("//a[contains(., 'MacBook Pro')]"));
        macBook_Air.click();
        WebElement macBook_AirPrecio = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"));
        System.out.println("El precio de la Mac Book Pro es: " + macBook_AirPrecio.getText());

        WebElement informacionDetallada = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        assertEquals("MacBook Pro", informacionDetallada.getText());
    }

    @Test
    public void obtenerValorDelli78gb(){
        //cuarto articulo
        WebElement laptops = driver.findElement(By.xpath("//*[@id='itemc'][2]"));
        laptops.click();
        WebElement dell_i7 = driver.findElement(By.xpath("//a[contains(., 'Dell i7 8gb')]"));
        dell_i7.click();
        WebElement dell_i7Precio = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"));
        System.out.println("El precio de la laptop Dell es: " + dell_i7Precio.getText());

        WebElement informacionDetallada = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        assertEquals("Dell i7 8gb", informacionDetallada.getText());
    }

    @Test
    public void obtenerValorASUSFullHD(){
        //quinto articulo
        WebElement monitors = driver.findElement(By.xpath("//*[@id='itemc'][3]"));
        monitors.click();
        WebElement asus_VS247H = driver.findElement(By.xpath("//a[contains(., 'ASUS Full HD')]"));
        asus_VS247H.click();
        WebElement asus_VS247HPrecio = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3"));
        System.out.println("El precio del monitor Asus es: " + asus_VS247HPrecio.getText());

        WebElement informacionDetallada = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        assertEquals("ASUS Full HD", informacionDetallada.getText());
    }

    @AfterEach
    public void cerrarNavegador(){
        driver.quit();
    }
}
