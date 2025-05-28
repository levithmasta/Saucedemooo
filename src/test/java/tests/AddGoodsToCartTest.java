package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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
        int actual = loginPage.open()
                .login(withAdminPermission())
                .isOpen()
                .addToCart(0)
                .addToCart(2)
                .addToCart(3)
                .openCart()
                .getProductsNames()
                .size();
        assertEquals(actual,3);
    }
}