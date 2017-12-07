package core;

import model.HelperBase;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPage extends HelperBase {

    private static final By EMAIL = By.id("field_email");
    private static final By PASSWORD = By.id("field_password");
    private static final By LOGIN_BUTTON = By.xpath(".//*[contains(@data-l,'loginButton')]");

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Field is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(EMAIL)));
        Assert.assertTrue("Field is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(PASSWORD)));
        Assert.assertTrue("Field is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(LOGIN_BUTTON)));
    }

    public void doLogin(TestBot testBot) {
        Assert.assertTrue("Field email is missing", isElementPresent(EMAIL));
        Assert.assertTrue("Field password is missing", isElementPresent(PASSWORD));
        Assert.assertTrue("Button login is missing", isElementPresent(LOGIN_BUTTON));
        type(testBot.getLogin(), EMAIL);
        type(testBot.getPassword(), PASSWORD);
        click(LOGIN_BUTTON);
    }

}

