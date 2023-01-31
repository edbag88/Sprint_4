package ru.services.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By cookiesButton = By.id("rcc-confirm-button");

    //Вопрос 1 "Сколько это стоит? И как оплатить?"
    private By question1 = By.id("accordion__heading-0");
    //Вопрос 2 Хочу сразу несколько самокатов! Так можно?
    private By question2 = By.id("accordion__heading-1");
    //Вопрос 3 Как рассчитывается время аренды?
    private By question3 = By.id("accordion__heading-2");
    //Вопрос 4 Можно ли заказать самокат прямо на сегодня?
    private By question4 = By.id("accordion__heading-3");
    //Вопрос 5 Можно ли продлить заказ или вернуть самокат раньше?
    private By question5 = By.id("accordion__heading-4");
    //Вопрос 6 Вы привозите зарядку вместе с самокатом?
    private By question6 = By.id("accordion__heading-5");
    //Вопрос 7 Можно ли отменить заказ?
    private By question7 = By.id("accordion__heading-6");
    //Вопрос 8 Я жизу за МКАДом, привезёте?
    private By question8 = By.id("accordion__heading-7");

    //Ответы
    //Ответ 1
    private By answer1 = By.id("accordion__panel-0");
    //Ответ 2
    private By answer2 = By.id("accordion__panel-1");
    //Ответ 3
    private By answer3 = By.id("accordion__panel-2");
    //Ответ 4
    private By answer4 = By.id("accordion__panel-3");
    //Ответ 5
    private By answer5 = By.id("accordion__panel-4");
    //Ответ 6
    private By answer6 = By.id("accordion__panel-5");
    //Ответ 7
    private By answer7 = By.id("accordion__panel-6");
    //Ответ 8
    private By answer8 = By.id("accordion__panel-7");

    //Текст ответов на вопросы
    //Текст ответа вопрос 1
    private String answerText1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Текст ответа вопрос 2
    private String answerText2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Текст ответа вопрос 3
    private String answerText3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Текст ответа вопрос 4
    private String answerText4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Текст ответа вопрос 5
    private String answerText5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Текст ответа вопрос 6
    private String answerText6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Текст ответа вопрос 7
    private String answerText7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Текст ответа вопрос 8
    private String answerText8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


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
    public void clickCookieButton() {
        driver.findElement(cookiesButton).click();
    }
    //нажать на вопрос
    public void clickQuestion(By question) {
        driver.findElement(question).click();
    }

    //получить текст ответа на вопрос
    public String getAnswerText(By answer){
        return driver.findElement(answer).getText();
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
