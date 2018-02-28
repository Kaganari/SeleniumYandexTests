import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class YandexTest {
    private static WebDriver driver = new ChromeDriver();
    Application app = new Application(driver);

    @Before
    public void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        app.fillInManufacturers();

    }

    @Test
    public void yandexMarketTestHpLenovo() throws InterruptedException {
        app.getToLaptops();
        app.showAllFilters();
        app.setPriceRange(0,30000);
        app.showAllManufacturers();
        app.checkManufacturers(new String[]{"HP","Lenovo"});//Check in two manufacturers - HP and Lenovo
        app.showResults();
        app.rememberResults();//Get all elements on the page to the list
        //Assert.assertEquals(myList.size(), 12);
        app.findFirstResult();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), app.getFirstResult());
    }

    @Test
    public void yandexMarketTestAcerDell() throws InterruptedException {
        app.getToLaptops();
        app.showAllFilters();
        app.setPriceRange(20000,25000);
        app.showAllManufacturers();
        app.checkManufacturers(new String[]{"Acer","Dell"});//Check in two manufacturers - Acer and DELL
        app.showResults();
        app.rememberResults();//Get all elements on the page to the list
        //Assert.assertEquals(myList.size(), 12);
        app.findFirstResult();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), app.getFirstResult());
    }

}
