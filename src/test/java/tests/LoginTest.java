package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Test(description = "проверка верной авторизации")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        //productsPage.ale();
        assertEquals(productsPage.getTitle(), "Products");
        assertTrue(productsPage.titleIsDisplayed());
        //productsPage.addToCart("Sauce Labs BackPack");
        productsPage.isOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(2);
        productsPage.addToCart(3);
        productsPage.openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }

    @DataProvider(name="incorrectLoginDate")
    public Object[][] loginData() {
       return new Object[][] {
               {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
               {"", "secret_sauce", "Epic sadface: Username is required"},
               {"standard_user", "secret_suce", "Epic sadface: Username and password do not match any user in this service"}
       };
    }

    @Test(dataProvider = "incorrectLoginDate")
    public void incorrectLogin(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getErrorsMsg(), errorMsg);
    }
}