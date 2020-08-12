package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id = 'identifierId']")
    private WebElement loginField;

    @FindBy(xpath = "//*[text() = 'Далее']/..")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@name = 'password']")
    private WebElement passwdField;

    @FindBy(xpath = "//*[@id = 'passwordNext']")
    private WebElement loginBtnPass;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickLoginBtnPassword() {
        loginBtnPass.click();
    }
}

