package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static enums.PageNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;
import static utils.AllureUtils.takeScreenshot;

public class LoginTest extends BaseTest {

    @Epic("Модуль логина интернет магазина")
    @Feature("Юридические лица")
    @Story("История")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Denis Vasilev")
    @TmsLink("homeworkPerLab")
    @Issue("Saucedemooo")
    @Flaky
    @Test(description = "проверка верной авторизации")
    public void correctLogin() {
        loginPage.open()
                .login(withAdminPermission());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
        assertTrue(productsPage.titleIsDisplayed());
    }

    @DataProvider(name = "incorrectLoginDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "secret_suce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Модуль логина интернет магазина")
    @Feature("Юридические лица")
    @Story("История")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Denis Vasilev")
    @TmsLink("homeworkPerLab")
    @Issue("Saucedemooo")
    @Test(dataProvider = "incorrectLoginDate")
    public void incorrectLogin(String user, String pass, String errorMsg) {
        loginPage.open()
                .fillLoginInput(user)
                .fillPasswordInput(pass)
                .clickSubmitBtn();
        assertEquals(loginPage.getErrorsMsg(), errorMsg);
    }
}