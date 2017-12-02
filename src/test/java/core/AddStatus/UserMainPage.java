package core.AddStatus;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");
    private static final By POST_AREA = By.xpath(".//*[@class='input_placeholder']");

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
}
