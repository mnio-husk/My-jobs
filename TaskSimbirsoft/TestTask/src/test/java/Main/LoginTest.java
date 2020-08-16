package Main;

import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LoginTest {
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public static WebDriver driver;
    private final String name = "farit.valiahmetov";
    private final String email = "farit.valiahmetov@simbirsoft.com";


    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    @DisplayName("authorization")
    public void loginTest() {

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);


        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtnPassword();

        profilePage.searchMessage(name);
        profilePage.userMessage();
        profilePage.nameUse(email);
        profilePage.topicUse("Тестовое задание. Попов");
        profilePage.bodyUse(profilePage.countLetters(name));
        profilePage.sendLetters();

    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}



