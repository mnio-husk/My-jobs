package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@aria-label = 'Главное меню']")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@class = 'T-I T-I-KE L3']")
    private WebElement messageButton;

    @FindBy(xpath = "//*[@name = 'subjectbox']")
    private WebElement topic;

    @FindBy(xpath = "//*[@name = 'to']")
    private WebElement nameMail;

    @FindBy(xpath = "//*[@class = 'Am Al editable LW-avf tS-tW']")
    private WebElement bodyText;

    @FindBy(xpath = "//*[@id=\":44\"]/div/div[2]/div")
    private WebElement numberLetters;

    @FindBy(xpath = "//*[@class = 'T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton;

    //Строка поиска
    @FindBy(xpath = "//*[@class = 'gb_uf']")
    private WebElement labelSearch;

    //Кнопка поиска
    @FindBy(xpath = "//*[@class = 'gb_Df gb_Ef']")
    private WebElement buttonSearch;

    public void userMessage() {
        messageButton.click();
    }

    public void topicUse(String text) {
        topic.click();
        topic.sendKeys(text);
    }

    public void nameUse(String name) {
        nameMail.click();
        nameMail.sendKeys(name);
    }

    public void bodyUse(String text) {
        bodyText.click();
        bodyText.sendKeys(text);
    }

    public String countLetters() {
        String number = numberLetters.getText();
        return number;
    }

    public void sendLetters() {
        sendButton.click();
    }
    public void searchMessage(String name){
        labelSearch.click();
        labelSearch.sendKeys(name);
        buttonSearch.click();
    }
}

