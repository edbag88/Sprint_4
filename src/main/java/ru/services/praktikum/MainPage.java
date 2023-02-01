package ru.services.praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {


    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //Заголовок страницы
    private By zagolovok = By.className("Home_Header__iJKdX");
    //Кнопка Заказать в заголовке
    private By buttonHeaderZakazat = By.className("Button_Button__ra12g");
    //Кнопка СтатусЗаказа
    private By buttonOrderStatus = By.className("Header_Link__1TAG7");
    //Кнопка Заказать
    private By buttonZakazat = By.className("Button_Button__ra12g");
    //
    private By logoSamokat = By.xpath(".//a[@href='/']");
    private By logoYandex = By.xpath(".//a[@href='//yandex.ru']");
    private By importantQuestions = By.xpath(".//div[text()='Вопросы о важном']");
    private final By cookieButton = By.className("App_CookieButton__3cvqF");


    //методы
    //клик на кнопку заказать в header
    public void clickButtonHeaderZakazat(){
        driver.findElement(buttonHeaderZakazat).click();
    }
    //клик на кнопку статус Заказа
    public void clickButtonOrderStatus(){
        driver.findElement(buttonOrderStatus).click();
    }
    //клик на кнопку заказать в центре страницы
    public void clickButtonZakazat() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonZakazat));
        driver.findElement(buttonZakazat).click();
    }
    //клик по кнопке Куки
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }
    //нажать на вопрос
    public void clickQuestion(int index) {
        driver.findElement(By.xpath(".//div[@id='accordion__heading-"+ index +"']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='accordion__panel-" + index + "']")));
    }
    //получить текст ответа на вопрос
    public String getAnswerText(int index){
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-" + index + "']")).getText();
    }
    //проскролить до элемента с вопросами
    public void scrollToElementImportantQuestions() {
        WebElement element = driver.findElement(importantQuestions );//текст вопросы о важном
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //клик по логотипу Самокат
    public void clickLogoSamokat(){
        driver.findElement(logoSamokat).click();
    }
    //клик по логотипу Яндекс
    public void clickLogoYandex(){
        driver.findElement(logoYandex).click();
    }

}
