package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateTest {
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
    public void test_Pas_aan_navigeert_naar_update_pagina() {
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();
        assertEquals("Update | Bieren", driver.getTitle());
    }

    @Test
    public void test_Bij_lege_velden_wordt_een_error_message_getoond() {
        //van overview naar update pagina
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();

        //alcoholpercentage leeg invullen
        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("");

        //score leeg invullen
        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("");

        //biersoort leeg invullen
        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("");

        //formulier verzenden
        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(list, "vul een geldig alcoholpercentage in (0-26)"));
        assertTrue(containsWebElementsWithText(list, "vul een geldige score in (0-10)"));
        assertTrue(containsWebElementsWithText(list, "vul een geldige biersoort in"));
    }

    @Test
    public void test_Bij_lege_score_wordt_error_message_getoond() {
        //van overview naar update pagina
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();

        //score leeg invullen
        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("");

        //formulier verzenden
        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(list, "vul een geldige score in (0-10)"));
    }

    @Test
    public void test_Bij_leeg_alcoholpercentage_wordt_error_message_getoond() {
        //van overview naar update pagina
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();

        //alcoholpercentage leeg invullen
        WebElement score = driver.findElement(By.id("alcoholpercentage"));
        score.clear();
        score.sendKeys("");

        //formulier verzenden
        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(list, "vul een geldig alcoholpercentage in (0-26)"));
    }

    @Test
    public void test_Bij_leeg_biersoort_wordt_error_message_getoond() {
        //van overview naar update pagina
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();

        //biersoort leeg invullen
        WebElement score = driver.findElement(By.id("biersoort"));
        score.clear();
        score.sendKeys("");

        //formulier verzenden
        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(list, "vul een geldige biersoort in"));
    }

    @Test
    public void test_Bij_ongeldige_score_wordt_error_message_getoond() {
        //van overview naar update pagina
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();

        //ongeldige score invullen
        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("-1");

        //formulier verzenden
        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(list, "vul een geldige score in (0-10)"));
    }

    @Test
    public void test_Bij_ongeldig_alcoholpercentage_wordt_error_message_getoond() {
        //van overview naar update pagina
        WebElement update = driver.findElement(By.linkText("Pas aan"));
        update.click();

        //ongeldig alcoholpercentage invullen
        WebElement score = driver.findElement(By.id("alcoholpercentage"));
        score.clear();
        score.sendKeys("-1");

        //formulier verzenden
        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(list, "vul een geldig alcoholpercentage in (0-26)"));
    }

//--------------------------------------------------------------------------------------------------------------------------------------------//

    //methode om door de list te gaan en te controleren of de tekst in de list voorkomt

    private boolean containsWebElementsWithText (ArrayList < WebElement > elements, String text){
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().equals(text)) {
                    return true;
                }
            }
            return false;
    }
}
