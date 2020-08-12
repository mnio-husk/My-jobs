package Main;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LoginTest {
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public WebDriver driver;
    private final String name = "Фарит Валиахметов";


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    }


    @Test
    public void loginTest() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtnPassword();

        profilePage.searchMessage(name);
        profilePage.userMessage();
        profilePage.nameUse(name);
        profilePage.topicUse("Тестовое задание. Попов");
        profilePage.bodyUse(profilePage.countLetters());
        profilePage.sendLetters();
        driver.quit();
    }
}



