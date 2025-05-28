package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector("[class='title']");
    private final By title2 = By.xpath("//*[text()='Products']");
    private final By addToCard = By.xpath("//*[text()='Add to cart']");
    private final By shopCart = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final String ADD_TO_CART_BUTTON_PATTERN
            = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка названия страницы")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Проверка отображения заголовка страницы")
    public boolean titleIsDisplayed() {
        return driver.findElement(title2).isDisplayed();
    }

    public void addToCart(String goodsName) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_BUTTON_PATTERN, goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Добавление товара в корзину")
    public ProductsPage addToCart(int index) {
        driver.findElements(addToCard).get(index).click();
        return this;
    }

    @Step("Ожидание прогрузки товара")
    public ProductsPage isOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return this;
    }

    @Step("Открытие корзины")
    public CartPage openCart() {
        driver.findElement(shopCart).click();
        return new CartPage(driver);
    }
}