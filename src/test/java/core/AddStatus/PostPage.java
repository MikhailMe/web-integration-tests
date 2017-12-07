package core.AddStatus;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");
    private static final By SHARE_BTN = By.cssSelector("#mtLayerMain .form-actions input[type='submit']");

    public PostPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем наличие
        Assert.assertTrue("Writing area is missing", isElementPresent(WRITING_AREA));
    }

    public void clickWritingArea() {
        // устанавливаем задержку, что @WRITING_AREA успела отобразиться
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(WRITING_AREA));
        // ещё раз проверяем наличие области для ввода статуса
        Assert.assertTrue("Writing area is missing", isElementPresent(WRITING_AREA));
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        // кликаем по области для ввода статуса
        click(WRITING_AREA);
        // теперь в область ввода статуса можно писать
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
    }

    public void typeStatus(String post) {

        // устанавливаем задержку, что @WRITING_AREA успела отобразиться
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(WRITING_AREA));

        // ещё раз проверяем видимость области для ввода статуса
        Assert.assertTrue("Writing area is missing(", isElementPresent(WRITING_AREA));
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        // пишем новый пост
        type(post, WRITING_AREA);
    }

    public void clickShareStatus() {
        // проверяем наличие и видимость кнопки "Поделиться статусом"
        //Assert.assertTrue("Share button is missing", isElementPresent(SHARE_BTN));
        Assert.assertTrue("Share button is not visible", isElementVisible(SHARE_BTN));
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.visibilityOfElementLocated(SHARE_BTN));

        // кликнули на кнопку
        click(SHARE_BTN);

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.invisibilityOfElementLocated(WRITING_AREA));

        // проверяем, что WRITING_AREA закрылась
        Assert.assertFalse("Writing area is visible", isElementVisible(WRITING_AREA));

        // проверили, что перешли на следующую страничку
        checkPresentElementsOnUserMainPage();
        checkVisibilityElementsOnUserMainPage();
    }
}
