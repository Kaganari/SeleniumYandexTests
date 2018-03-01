import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 01.03.2018.
 */
public class YandexMarketPage {
    private WebDriver driver;
    YandexMarketPage(WebDriver driver){
        this.driver = driver;
    }

    public void toPCs() {
        driver.findElement(By.linkText("Компьютеры")).click();
    }
}
