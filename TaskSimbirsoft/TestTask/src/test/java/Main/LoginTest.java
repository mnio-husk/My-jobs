package Main;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    public void loginTest() {

        loginPage.inputLogin(ConfProperties.getProperty("login"));

        loginPage.clickLoginBtn();

        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        loginPage.clickLoginBtnPassword();

    }


    @AfterClass
    public static void tearDown() {
        profilePage.userMassage();
        profilePage.nameUse("Фарита Валиахметова");
        profilePage.topicUse("Тестовое задание. Попов");
        profilePage.bodyUse(profilePage.countLetters());
        profilePage.sendLetters();
        driver.quit();

    }
}



