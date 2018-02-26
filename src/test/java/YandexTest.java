import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;

public class YandexTest {
    private static WebDriver driver = new ChromeDriver();

    @Before
    public void setup() {
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void yandexMarketTest2() throws InterruptedException {
        getToNotebooks();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[32]/div[2]/a")).click();//Show all filters

        driver.findElement(By.id("glf-priceto-var")).sendKeys("30000");
        WebElement manufacturers = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]"));//The field with checkboxes for manufacturers
        manufacturers.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/button")).click();//Show all
        checkManufacturers(new String[]{"glf-7893318-152722","glf-7893318-152981"}, manufacturers);//Check in two manufacturers - HP and Lenovo

        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[5]/a[2]")).click();//Apply filters
        List<WebElement> myList = driver.findElements(By.className("n-snippet-card2__title"));//Get all elements on the page to the list
        //Assert.assertEquals(myList.size(), 12);
        String firstResult = myList.get(0).getText();

        driver.findElement(By.id("header-search")).sendKeys(myList.get(0).getText());
        driver.findElement(By.className("button2_type_submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/h1")).getText(), firstResult);
    }

    @Test
    public void yandexMarketTest3() throws InterruptedException {
        getToNotebooks();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[32]/div[2]/a")).click();//Show all filters

        driver.findElement(By.id("glf-pricefrom-var")).sendKeys("20000");
        driver.findElement(By.id("glf-priceto-var")).sendKeys("25000");

        WebElement manufacturers = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]")); //The field with checkboxes for manufacturers
        manufacturers.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/button")).click();//Show all
        checkManufacturers(new String[]{"glf-7893318-267101","glf-7893318-153080"}, manufacturers);//Check in two manufacturers - Acer and DELL

        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[5]/a[2]")).click();//Apply filters
        List<WebElement> myList = driver.findElements(By.className("n-snippet-card2__title"));//Get all elements on the page to the list
        //Assert.assertEquals(myList.size(), 12);
        String firstResult = myList.get(0).getText();

        driver.findElement(By.id("header-search")).sendKeys(myList.get(0).getText());
        driver.findElement(By.className("button2_type_submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/h1")).getText(), firstResult);
    }

    public static void getToNotebooks() {
        driver.get("https://yandex.ru/");
        driver.findElement(By.linkText("Маркет")).click();
        driver.findElement(By.linkText("Компьютеры")).click();
        driver.findElement(By.linkText("Ноутбуки")).click();
    }

    public static void checkManufacturers(String[] mnf_ids, WebElement manufacturers) throws InterruptedException {
        for (int i = 0; i < mnf_ids.length; i++) {
            Thread.sleep(200);
            manufacturers.findElement(By.id(mnf_ids[i])).sendKeys(Keys.SPACE);
        }
    }
}
