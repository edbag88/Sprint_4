import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.services.praktikum.MainPage;
import ru.services.praktikum.OrderPage;


import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class OrderScooterTest extends BaseTest{
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String comment;

    public OrderScooterTest(String name, String surname, String address, String phone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    @Parameterized.Parameters(name="name={0}, surname={1}, address={2},phone={3}, comment={4}")
    public static Object[] dataGen(){
        return new Object[][]{
                {"Иван","Иванов","ул Красивая 1","89999999999","нет необходимости"},
                {"Петя", "Петров","ул Аксакова 88А","79888888888", "позвоните за 10 минут"},
        };
    }
    //Тест через кнопку заказать в заголовке
    @Test
    public void checkButtonHeaderZakazat() {


        // Объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);


        // Объект класса страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //клик по кнопке заказать
        objMainPage.clickButtonHeaderZakazat();

        //Заполнить первую часть формы данными
        objOrderPage.setOrderFormPart1(name,surname,address,phone);

        //Клик по кнопке далее
        objOrderPage.clickButtonNext();

        //Заполнить вторую часть формы данными
        objOrderPage.setOrderFormPart2(comment);

        //Клик по кнопке заказать
        objOrderPage.clickButtonOrder();

        //Клик по кнопке Да
        objOrderPage.clickButtonYes();

        MatcherAssert.assertThat(objOrderPage.getTextHeaderWindow(), allOf(startsWith("Заказ оформлен"),containsString("Номер заказа")));
    }
    //Тест через кнопку заказать в центре страницы
    @Test
    public void checkButtonZakazat() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // Объект класса страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);


        //клик по кнопке заказать
        objMainPage.clickButtonZakazat();

        //Заполнить первую часть формы данными
        objOrderPage.setOrderFormPart1(name,surname,address,phone);

        //Клик по кнопке далее
        objOrderPage.clickButtonNext();

        //Заполнить вторую часть формы данными
        objOrderPage.setOrderFormPart2(comment);

        //Клик по кнопке заказать
        objOrderPage.clickButtonOrder();

        //Клик по кнопке Да
        objOrderPage.clickButtonYes();

        MatcherAssert.assertThat(objOrderPage.getTextHeaderWindow(), allOf(startsWith("Заказ оформлен"),containsString("Номер заказа")));
    }
}





