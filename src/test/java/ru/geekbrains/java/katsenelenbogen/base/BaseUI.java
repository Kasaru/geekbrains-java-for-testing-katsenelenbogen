package ru.geekbrains.java.katsenelenbogen.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.java.katsenelenbogen.AccountPage;
import ru.geekbrains.java.katsenelenbogen.MainPage;
import ru.geekbrains.java.katsenelenbogen.RegistrationPage;
import ru.geekbrains.java.katsenelenbogen.SignInPage;

public class BaseUI {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected MainPage mainPage;
    protected SignInPage signInPage;
    protected RegistrationPage registrationPage;
    protected AccountPage accountPage;


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 3);
        mainPage = new MainPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
        accountPage = new AccountPage(driver, wait);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

