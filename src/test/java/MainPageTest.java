import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import ru.services.praktikum.MainPage;



public class MainPageTest extends BaseTest{

    //Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    @Test
    public void checkAfterClickSamokatLogo(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        String currentTitle = driver.getTitle();
        objMainPage.clickLogoSamokat();
        String titleAfterClickLogoSamokat = driver.getTitle();
        MatcherAssert.assertThat(titleAfterClickLogoSamokat, is(currentTitle));
        System.out.println(currentTitle);

    }

}