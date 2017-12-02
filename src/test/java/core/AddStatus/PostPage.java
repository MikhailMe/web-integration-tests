package core.AddStatus;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PostPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");
    private static final By SHARE_BTN = By.cssSelector("#mtLayerMain .form-actions input[type='submit']");

    public PostPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем наличие
        Assert.assertTrue("Writing area is missing", isElementPresent(WRITING_AREA));
        // проверяем видимость
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
    }

    public void clickWritingArea() {
        Assert.assertTrue("Writing area is missing", isElementPresent(WRITING_AREA));
        click(WRITING_AREA);
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
    }

    public void typeStatus(String post) {
        // ещё раз проверяем видимость области для ввода статуса
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        // пишем новый пост
        type(post, WRITING_AREA);
    }

    public void clickShareStatus() {
        Assert.assertTrue("Share button is not visible", isElementVisible(SHARE_BTN));
        // кликнули на кнопку
        click(SHARE_BTN);
        // проверили, что перешли на следующую страничку
        checkPresentElementsOnUserMainPage();
    }
}
