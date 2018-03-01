import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 01.03.2018.
 */
public class YandexMainPage {
    private WebDriver driver;
    YandexMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void toMarket() {
        driver.findElement(By.linkText("Маркет")).click();
    }

    public void toYandex() {
        driver.get("https://yandex.ru/");
    }
}
