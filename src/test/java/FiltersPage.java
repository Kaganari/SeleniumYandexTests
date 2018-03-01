import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 28.02.2018.
 */
public class FiltersPage {
    private WebDriver driver;
    Map<String, String> manufacturers = new HashMap<String,String>();


    FiltersPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillInManufacturers() {
        manufacturers.put("HP","glf-7893318-152722");
        manufacturers.put("Lenovo","glf-7893318-152981");
        manufacturers.put("Acer","glf-7893318-267101");
        manufacturers.put("Dell","glf-7893318-153080");
    }

    public void checkManufacturers(String[] mnf_ids) throws InterruptedException {
        for (String mnf_id : mnf_ids) {
            Thread.sleep(200);
            driver.findElement(By.id(manufacturers.get(mnf_id))).sendKeys(Keys.SPACE);
        }
    }

    public void setPriceRange(final int from, final int to) {
        driver.findElement(By.id("glf-pricefrom-var")).sendKeys(String.valueOf(from));
        driver.findElement(By.id("glf-priceto-var")).sendKeys(String.valueOf(to));
    }

    public void showAllManufacturers() {
        driver.findElement(By.xpath("//*[@class='button__text']//parent::button")).click();
    }

    public void showResults() {
        driver.findElement(By.xpath("//span[text()='Показать подходящие']//ancestor::div[1]")).click();
    }

}
