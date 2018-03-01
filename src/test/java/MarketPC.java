import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 01.03.2018.
 */
public class MarketPC {
    private WebDriver driver;
    MarketPC(WebDriver driver){
        this.driver = driver;
    }

    public void toLaptops() {
        driver.findElement(By.linkText("Ноутбуки")).click();
    }
}
