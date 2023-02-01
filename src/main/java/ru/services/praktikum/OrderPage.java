package ru.services.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class OrderPage {

    protected WebDriver driver;

    public OrderPage(WebDriver driver) {

        this.driver = driver;
    }
    //Имя
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Метро
    private By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    //Телефон
    private By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Про аренду
    //Когда привезти самокат
    private By inputReturnDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //срок аренды
    private By inputTermRental = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By inputListTermRental = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    //чек бокс черный
    private By inputCheckBoxBlack = By.id("black");
    //чек бокс серый
    private By inputCheckBoxGrey = By.id("grey");
    //Комментарий
    private By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка назад
    private By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    //кнопка заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private By headerWindow = By.className("Order_ModalHeader__3FDaJ");


    //методы
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setMetro() {
        driver.findElement(inputMetro).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void setOrderFormPart1(String name, String surname,String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro();
        setPhone(phone);
    }



    //клик по кнопке далее
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void setDate() {
        driver.findElement(inputReturnDate).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setCountDates() {
        driver.findElement(inputTermRental).click();
        driver.findElement(inputListTermRental).click();
    }
    public void setColorScooter() {
        driver.findElement(inputCheckBoxBlack).click();
    }

    public void setComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }

    public void setOrderFormPart2(String comment){
        setDate();
        setCountDates();
        setColorScooter();
        setComment(comment);
    }
    //клик по кнопке заказа
    public void clickButtonOrder() {
        driver.findElement(orderButton).click();
    }
    //клик по кнопке да
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    //текст из окна заголовка
    public String getTextHeaderWindow() {

        return driver.findElement(headerWindow).getText();
    }
}
