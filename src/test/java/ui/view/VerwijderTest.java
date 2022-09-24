package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class VerwijderTest {
    private static final String url = "http://cyclone3.uclllabs.be:8081/Tas-Lukas_war/";
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "Servlet?command=overzicht");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Verwijder_navigeert_naar_verwijderBevestig_pagina() {
        WebElement update = driver.findElement(By.linkText("Verwijder"));
        update.click();
        assertEquals("Verwijderen | Bieren", driver.getTitle());
    }

    @Test
    public void test_Verwijderen_brengt_je_naar_overzicht_page() {
        WebElement verwijder = driver.findElement(By.linkText("Verwijder"));
        verwijder.click();

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Overzicht | Bieren", driver.getTitle());
    }
}
