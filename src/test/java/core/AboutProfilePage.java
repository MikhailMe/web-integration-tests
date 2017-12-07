package core;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutProfilePage extends HelperBase {

    private static final By EDIT_USER_PROFILE_FORM = By.id("hook_Form_PopLayerEditUserProfileNewForm");
    private static final By SURNAME = By.id("field_surname");
    private static final By SUMMARY_ABOUT_USER = By.id("hook_Block_AboutUserSummaryEditable");
    private static final By USER_PROFILE_INTERESTS = By.id("hook_Block_UserProfileInterests");
    private static final By CHANGE_OWN_DATA_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile&cmd=PopLayer')]");

    public AboutProfilePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Summary about user is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(SUMMARY_ABOUT_USER)));
        Assert.assertTrue("User profile interests are not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(USER_PROFILE_INTERESTS)));
        Assert.assertTrue("Change own data button is missing",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(CHANGE_OWN_DATA_BTN)));

    }

    public void clickChangeOwnData() {
        Assert.assertTrue("Change own data button is missing", isElementVisible(CHANGE_OWN_DATA_BTN));
        click(CHANGE_OWN_DATA_BTN);
        Assert.assertTrue("Edit form is missing", isElementVisible(EDIT_USER_PROFILE_FORM));
        Assert.assertTrue("Surname field is missing", isElementVisible(SURNAME));
    }
}
