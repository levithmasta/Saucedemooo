package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private final By errorSign = By.xpath("//*[@data-test='error']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Ввод данных пользователя")
    public ProductsPage login(User user) {
        fillLoginInput(user.getEmail());
        fillPasswordInput(user.getPassword());
        clickSubmitBtn();
        return new ProductsPage(driver);
    }

    public LoginPage fillLoginInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        return this;
    }

    public LoginPage fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Нажатие на кнопку Login")
    public LoginPage clickSubmitBtn() {
        driver.findElement(LOGIN_BUTTON).submit();
        return this;
    }

    public String getErrorsMsg() {
        return driver.findElement(errorSign).getText();
    }
}