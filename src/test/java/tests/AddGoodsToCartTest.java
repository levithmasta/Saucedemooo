package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class AddGoodsToCartTest extends BaseTest {
    @Epic("Модуль логина интернет магазина")
    @Feature("Юридические лица")
    @Story("История")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Denis Vasilev")
    @TmsLink("homeworkPerLab")
    @Issue("Saucedemooo")
    @Test(description = "Проверяем, что товары добавлены в корзину")
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.isOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(2);
        productsPage.addToCart(3);
        productsPage.openCart();
        assertEquals(cartPage.getProductsNames().size(), 3);
    }
}

