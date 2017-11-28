package core.AddStatus;

import model.HelperBase;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMainPage extends HelperBase {

    private static final By email = By.id("field_email");
    private static final By password = By.id("field_password");
    private static final By loginButton = By.xpath(".//*[contains(@data-l,'loginButton')]");

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Field email is missing", isElementPresent(email));
        Assert.assertTrue("Field password is missing", isElementPresent(password));
        Assert.assertTrue("Button login is missing", isElementPresent(loginButton));
    }

    public void doLogin(TestBot testBot) {
        type(testBot.getLogin(), email);
        type(testBot.getPassword(), password);
        click(loginButton);
    }
}
