import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class YandexTest {
    private static WebDriver cromeDriver = new ChromeDriver();

    @Before
    public void setup() {
        cromeDriver.manage().window().maximize();
        cromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void yandexMarketTestHpLenovo() throws InterruptedException {
        YandexMainPage mainPage = new YandexMainPage(cromeDriver);
        mainPage.toYandex();
        mainPage.toMarket();
        YandexMarketPage marketPage = new YandexMarketPage(cromeDriver);
        marketPage.toPCs();
        MarketPC pcsPage = new MarketPC(cromeDriver);
        pcsPage.toLaptops();
        MarketLaptops laptopsPage = new MarketLaptops(cromeDriver);
        laptopsPage.toAllFilters();
        FiltersPage filtersPage = new FiltersPage(cromeDriver);
        filtersPage.fillInManufacturers();
        filtersPage.setPriceRange(0,30000);
        filtersPage.showAllManufacturers();
        filtersPage.checkManufacturers(new String[]{"HP", "Lenovo"});
        filtersPage.showResults();
        laptopsPage.rememberResults();
        laptopsPage.findFirstResult();
        ResultPage resultPage = new ResultPage(cromeDriver);
        //Assert.assertEquals(myList.size(), 12);
        Assert.assertEquals(resultPage.getResultName(), laptopsPage.getFirstResult());
    }

    @Test
    public void yandexMarketTestAcerDell() throws InterruptedException {
        YandexMainPage mainPage = new YandexMainPage(cromeDriver);
        mainPage.toYandex();
        mainPage.toMarket();
        YandexMarketPage marketPage = new YandexMarketPage(cromeDriver);
        marketPage.toPCs();
        MarketPC pcsPage = new MarketPC(cromeDriver);
        pcsPage.toLaptops();
        MarketLaptops laptopsPage = new MarketLaptops(cromeDriver);
        laptopsPage.toAllFilters();
        FiltersPage filtersPage = new FiltersPage(cromeDriver);
        filtersPage.fillInManufacturers();
        filtersPage.setPriceRange(200000,25000);
        filtersPage.showAllManufacturers();
        filtersPage.checkManufacturers(new String[]{"Acer", "Dell"});
        filtersPage.showResults();
        laptopsPage.rememberResults();
        laptopsPage.findFirstResult();
        ResultPage resultPage = new ResultPage(cromeDriver);
        //Assert.assertEquals(myList.size(), 12);
        Assert.assertEquals(resultPage.getResultName(), laptopsPage.getFirstResult());
    }
}
