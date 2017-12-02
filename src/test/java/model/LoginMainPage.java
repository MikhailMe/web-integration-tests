package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMainPage extends HelperBase {

    private static final By EMAIL = By.id("field_email");
    private static final By PASSWORD = By.id("field_password");
    private static final By LOGIN_BUTTON = By.xpath(".//*[contains(@data-l,'loginButton')]");

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем существование элементов
        Assert.assertTrue("Field email is missing", isElementPresent(EMAIL));
        Assert.assertTrue("Field password is missing", isElementPresent(PASSWORD));
        Assert.assertTrue("Button login is missing", isElementPresent(LOGIN_BUTTON));
        // проверяем видимость этих элементов
        Assert.assertTrue("Field is not visible", isElementVisible(EMAIL));
        Assert.assertTrue("Field is not visible", isElementVisible(PASSWORD));
        Assert.assertTrue("Field is not visible", isElementVisible(LOGIN_BUTTON));

    }

    public void doLogin(TestBot testBot) {
        // ещё раз наличие элементов
        Assert.assertTrue("Field email is missing", isElementPresent(EMAIL));
        Assert.assertTrue("Field password is missing", isElementPresent(PASSWORD));
        Assert.assertTrue("Button login is missing", isElementPresent(LOGIN_BUTTON));
        type(testBot.getLogin(), EMAIL);
        type(testBot.getPassword(), PASSWORD);
        click(LOGIN_BUTTON);
        // проверяем, что перещли на главную страничку
        checkPresentElementsOnUserMainPage();
    }

}

