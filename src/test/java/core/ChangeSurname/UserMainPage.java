package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

    private static final By FULL_NAME = By.xpath(".//*[@class='mctc_nameLink']");
    private static final By ABOUT_USER = By.id("hook_Block_AboutUser");
    private static final By CHANGE_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile')]");
    private static final By NAME = By.cssSelector(".mctc_name_tx");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем наличие элеметов на главной странице
        checkPresentElementsOnUserMainPage();
        // проверяем видимость элеметов на главной странице
        checkVisibilityElementsOnUserMainPage();
    }

    public void clickFullName() {
        // проверяем наличие и видимость имени
        Assert.assertTrue("Full name is missing", isElementPresent(FULL_NAME));
        Assert.assertTrue("Full name is not visible", isElementVisible(FULL_NAME));
        // кликаем по кнопке
        click(FULL_NAME);
        // проверили, что перешли на следующую страничку
        Assert.assertTrue("Area about user is missing", isElementPresent(ABOUT_USER));
        Assert.assertTrue("Change button is missing", isElementPresent(CHANGE_BTN));
    }

    public String getSurname() {
        // проверили наличие и видимость имени
        Assert.assertTrue("Name is missing", isElementPresent(NAME));
        Assert.assertTrue("Name is not visible", isElementVisible(NAME));
        return driver.findElement(NAME).getText();
    }
}
