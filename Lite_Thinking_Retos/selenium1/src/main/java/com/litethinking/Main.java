package com.litethinking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement textArea = driver.findElement(By.id("APjFqb"));
        textArea.sendKeys("Selenium Web Driver");

        WebElement buttonSearch = driver.findElement(By.name("btnK"));
        buttonSearch.click();

        System.out.println("Titulo del navegador: " + driver.getTitle());

        if (driver.getTitle().equals("Selenium Web Driver - Buscar con Google")) {
            System.out.println("La prueba fue exitosa");
        } else {
            System.out.println("La prueba fue fallida");
        }

        driver.close();
        driver.quit();
    }
}
