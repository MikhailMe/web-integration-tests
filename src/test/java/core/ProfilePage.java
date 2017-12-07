package core;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        Assert.assertTrue("Area about user is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(ABOUT_USER)));
        Assert.assertTrue("Change button is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(CHANGE_BTN)));
    }

    public void clickChangeData() {
        Assert.assertTrue("Change button is not visible", isElementVisible(CHANGE_BTN));
        click(CHANGE_BTN);
        Assert.assertTrue("Change button is not visible", isElementVisible(SUMMARY_ABOUT_USER));
        Assert.assertTrue("User profile interests are missing", isElementVisible(USER_PROFILE_INTERESTS));
        Assert.assertTrue("Change own data button is missing", isElementVisible(CHANGE_OWN_DATA_BTN));
    }
}
