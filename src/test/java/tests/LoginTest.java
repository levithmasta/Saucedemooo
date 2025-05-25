package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "проверка верной авторизации")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        assertTrue(productsPage.titleIsDisplayed());
    }

    @Test(dependsOnMethods = "correctLogin")
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertTrue(driver.findElement(By.xpath("//*[text()='Products']")).isDisplayed());
    }

    @Test(invocationCount = 2)
    public void incorrectPasswordLogin() {
        loginPage.open();
        loginPage.login("", "secret_suce");
        assertEquals(productsPage.getTitle(), "Products");
    }
}