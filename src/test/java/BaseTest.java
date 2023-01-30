import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        driver = new ChromeDriver();
        //для запуска через firefox
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //делаем страницу под размер экрана
        driver.manage().window().maximize();
        //ожидаем загрузку страницы
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //ожидаем загрузку элементов
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    //выход
    @After
    public void tearDown(){
        driver.quit();
    }
}
