package core.AddStatus;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");

    private static final By SHARE_BTN = By.cssSelector("#mtLayerMain .form-actions input[type='submit']");

    public PostPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Writing area is missing", isElementPresent(WRITING_AREA));
    }

    public void typeStatus(String post) {
        type(post, WRITING_AREA);
    }

    public void clickShareStatus() {
        click(SHARE_BTN);
    }
}
