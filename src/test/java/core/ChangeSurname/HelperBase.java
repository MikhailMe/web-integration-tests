package core.ChangeSurname;

import org.openqa.selenium.*;

public abstract class HelperBase {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;

    HelperBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    void click(By locator) {
        driver.findElement(locator).click();
    }
}