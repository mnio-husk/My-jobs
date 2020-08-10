package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@aria-label, 'Главное меню')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'T-I T-I-KE L3')]")
    private WebElement massageButton;

    @FindBy(xpath = "//*[contains(@name, 'subjectbox')]")
    private WebElement topic;

    @FindBy(xpath = "//*[contains(@name, 'to')]")
    private WebElement nameMail;

    @FindBy(xpath = "//*[contains(@class, 'Am Al editable LW-avf tS-tW')]")
    private WebElement bodyText;

    @FindBy(xpath = "//*[contains(@class, 'bsU')]")
    private WebElement numberLetters;

    @FindBy(xpath = "//*[contains(@class, 'T-I J-J5-Ji aoO v7 T-I-atl L3')]")
    private WebElement sendButton;



    public void userMassage() {
        massageButton.click();
    }

    public void topicUse(String text) {
        topic.click();
        topic.sendKeys(text);
    }

    public void nameUse(String name){
        nameMail.click();
        nameMail.sendKeys(name);
    }

    public void bodyUse(String text){
        bodyText.click();
        bodyText.sendKeys(text);
    }

    public String countLetters(){
       String number = numberLetters.getText();
       return number;
    }

    public void sendLetters(){
        sendButton.click();

    }
}

