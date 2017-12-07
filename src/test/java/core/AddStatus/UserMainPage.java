package core.AddStatus;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");
    private static final By POST_AREA = By.xpath(".//*[@class='input_placeholder']");
    private static final By NOTES = By.id("hook_Block_MiddleColumnTopCard_MenuUser");
    private static final By USER_STATUSES = By.id("hook_Block_UserStatusesMRB");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем существование элементов
        checkPresentElementsOnUserMainPage();
        // проверяем видимость этих элеметов
        checkVisibilityElementsOnUserMainPage();
    }

    public void clickPost() {
        // проверить видимость
        Assert.assertTrue("Post area is not visible", isElementVisible(POST_AREA));
        // кликаем по области "О чём вы думаете"
        click(POST_AREA);
        // проверяем наличие области для написания статуса
        Assert.assertTrue("Writing area is missing", isElementPresent(WRITING_AREA));
    }

    public void clickNotes() {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.visibilityOfElementLocated(NOTES));

        // проверяем наличие и видимость иконки "заметки"
        Assert.assertTrue("", isElementPresent(NOTES));
        Assert.assertTrue("", isElementVisible(NOTES));
        // кликаем по иконке "заметки"
        click(NOTES);
        // проверяем переход на страничку заметок
        Assert.assertTrue("", isElementPresent(USER_STATUSES));
        Assert.assertTrue("", isElementVisible(USER_STATUSES));
    }
}
