package core;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");
    private static final By SHARE_BTN = By.cssSelector("#mtLayerMain .form-actions input[type='submit']");

    public PostPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Writing area is missing",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementPresent(WRITING_AREA)));
    }

    public void clickWritingArea() {
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        click(WRITING_AREA);
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
    }

    public void typeStatus(String post) {
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        type(post, WRITING_AREA);
    }

    public void clickShareStatus() {
        Assert.assertTrue("Share button is not visible", isElementVisible(SHARE_BTN));
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        click(SHARE_BTN);
        Assert.assertFalse("Writing area is visible", isElementVisible(WRITING_AREA));
    }
}
