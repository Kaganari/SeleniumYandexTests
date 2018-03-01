import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 01.03.2018.
 */
public class ResultPage {
    private WebDriver driver;
    ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getResultName() {
        return (driver.findElement(By.tagName("h1")).getText());
    }
}
