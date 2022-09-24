package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class ZoekTest {
    private static final String url = "http://cyclone3.uclllabs.be:8081/Tas-Lukas_war/";
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "Servlet?command=zoek");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Succesvolle_zoekopdracht_toont_gevonden_pagina() {
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("Duvel");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Gevonden | Bieren", driver.getTitle());
    }

    @Test
    public void test_Niet_succesvolle_zoekopdracht_toont_niet_gevonden_pagina() {
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("onbestaand bier");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Niet Gevonden | Bieren", driver.getTitle());
    }

    @Test
    public void test_Lege_zoekopdracht_toont_niet_gevonden_pagina() {
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Niet Gevonden | Bieren", driver.getTitle());
    }

}
