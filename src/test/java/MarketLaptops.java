import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 01.03.2018.
 */
public class MarketLaptops {
    List<WebElement> listOfResults;
    String firstResult;
    private WebDriver driver;
    MarketLaptops(WebDriver driver){
        this.driver = driver;
    }

    public void toAllFilters() {
        driver.findElement(By.xpath("//*[@class='n-filter-panel-aside__content']//*[text()='Перейти ко всем фильтрам']")).click();
    }

    public void rememberResults() {
        listOfResults = driver.findElements(By.className("n-snippet-card2__title"));
        firstResult = listOfResults.get(0).getText();
    }

    public void findFirstResult() {
        driver.findElement(By.id("header-search")).sendKeys(firstResult);
        driver.findElement(By.className("button2_type_submit")).click();
    }

    public String getFirstResult() {
        return firstResult;
    }
}
