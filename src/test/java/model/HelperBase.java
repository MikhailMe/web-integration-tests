package model;

import org.junit.Assert;
import org.openqa.selenium.*;

public abstract class HelperBase {

    private static final By MIDDLE_COLUMN = By.id("hook_Block_MiddleColumnTopCard");
    private static final By LEFT_COLUMN = By.id("hook_Block_LeftColumnTopCardUser");
    private static final By POSTING_FORM = By.id("hook_Block_PostingForm");
    private static final By POST_AREA = By.xpath(".//*[@class='input_placeholder']");

    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    protected void type(String text, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    // проверяем, то что находимся на главной страничке
    protected void checkPresentElementsOnUserMainPage() {
        // проверяем страницу на которую перешли
        Assert.assertTrue("Middle column is missing", isElementPresent(MIDDLE_COLUMN));
        Assert.assertTrue("Left column is missing", isElementPresent(LEFT_COLUMN));
        Assert.assertTrue("Posting form is missing", isElementPresent(POSTING_FORM));
        Assert.assertTrue("Post area is missing", isElementPresent(POST_AREA));
    }

    // проверяем видимость элеметов на главной страничке
    protected void checkVisibilityElementsOnUserMainPage() {
        Assert.assertTrue("Middle column is not visible", isElementVisible(MIDDLE_COLUMN));
        Assert.assertTrue("Left column is not visible", isElementVisible(LEFT_COLUMN));
        Assert.assertTrue("Posting form is not visible", isElementVisible(POSTING_FORM));
        Assert.assertTrue("Post area is not visible", isElementVisible(POST_AREA));
    }
}
