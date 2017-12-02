package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends HelperBase {

    private static final By SUMMARY_ABOUT_USER = By.id("hook_Block_AboutUserSummaryEditable");
    private static final By USER_PROFILE_INTERESTS = By.id("hook_Block_UserProfileInterests");
    private static final By CHANGE_OWN_DATA_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile&cmd=PopLayer')]");
    private static final By ABOUT_USER = By.id("hook_Block_AboutUser");
    private static final By CHANGE_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile')]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем наличие
        Assert.assertTrue("Area about user is missing", isElementPresent(ABOUT_USER));
        Assert.assertTrue("Change button is missing", isElementPresent(CHANGE_BTN));
        // проверяем видимость
        Assert.assertTrue("Area about user is not visible", isElementVisible(ABOUT_USER));
        Assert.assertTrue("Change button is not visible", isElementVisible(CHANGE_BTN));
    }

    public void clickChangeData() {
        // ещё раз проверяем наличие и видимость кнопки
        Assert.assertTrue("Change button is missing", isElementPresent(CHANGE_BTN));
        Assert.assertTrue("Change button is not visible", isElementVisible(CHANGE_BTN));
        // кликаем по кнопке
        click(CHANGE_BTN);
        // проверили, что перешли на следующую страничку
        Assert.assertTrue("Summary about user is missing", isElementPresent(SUMMARY_ABOUT_USER));
        Assert.assertTrue("User profile interests are missing", isElementPresent(USER_PROFILE_INTERESTS));
        Assert.assertTrue("Change own data button is missing", isElementPresent(CHANGE_OWN_DATA_BTN));
    }
}
