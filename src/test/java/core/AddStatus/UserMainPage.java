package core.AddStatus;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

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
        click(POST_AREA);
    }
}
