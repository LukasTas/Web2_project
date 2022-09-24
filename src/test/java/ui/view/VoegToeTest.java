package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class VoegToeTest {
    private static final String url = "http://cyclone3.uclllabs.be:8081/Tas-Lukas_war/";
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "Servlet?command=voegtoeForm");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Overzicht_wordt_getoond_bij_correct_invullen_formulier() {
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("Delirium tremens");

        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("8.5");

        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("5");

        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("sterk blond");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Overzicht | Bieren", driver.getTitle());
    }

    @Test
    public void test_Formulier_wordt_opnieuw_getoond_met_bijhorende_error_message_als_naam_leeg_is(){
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("");

        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("8.5");

        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("5");

        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("sterk blond");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Voeg toe | Bieren", driver.getTitle());

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementWithText(list, "vul een geldige naam in"));
    }

    @Test
    public void test_Formulier_wordt_opnieuw_getoond_met_bijhorende_error_message_als_alcoholpercentage_leeg_is(){
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("Delirium tremens");

        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("");

        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("5");

        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("sterk blond");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Voeg toe | Bieren", driver.getTitle());

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementWithText(list, "vul een geldig alcoholpercentage in (0-26)"));

    }

    @Test
    public void test_Formulier_wordt_opnieuw_getoond_met_bijhorende_error_message_als_score_leeg_is(){
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("Delirium tremens");

        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("8.5");

        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("");

        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("sterk blond");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Voeg toe | Bieren", driver.getTitle());

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementWithText(list, "vul een geldige score in (0-10)"));
    }

    @Test
    public void test_Formulier_wordt_opnieuw_getoond_met_bijhorende_error_message_als_biersoort_leeg_is(){
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("Delirium tremens");

        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("8.5");

        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("5");

        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Voeg toe | Bieren", driver.getTitle());

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementWithText(list, "vul een geldige biersoort in"));
    }

    @Test
    public void test_Formulier_wordt_opnieuw_getoond_met_bijhorende_error_message_als_alles_leeg_is(){
        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("");

        WebElement alcoholpercentage = driver.findElement(By.id("alcoholpercentage"));
        alcoholpercentage.clear();
        alcoholpercentage.sendKeys("");

        WebElement score = driver.findElement(By.id("score"));
        score.clear();
        score.sendKeys("");

        WebElement biersoort = driver.findElement(By.id("biersoort"));
        biersoort.clear();
        biersoort.sendKeys("");

        WebElement button = driver.findElement(By.id("submit-button"));
        button.click();

        assertEquals("Voeg toe | Bieren", driver.getTitle());

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementWithText(list, "vul een geldige naam in"));
        assertTrue(containsWebElementWithText(list, "vul een geldig alcoholpercentage in (0-26)"));
        assertTrue(containsWebElementWithText(list, "vul een geldige score in (0-10)"));
        assertTrue(containsWebElementWithText(list, "vul een geldige biersoort in"));
    }

    private boolean containsWebElementWithText(ArrayList<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}
