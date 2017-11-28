package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutProfilePage extends HelperBase {

    private static final By SUMMARY_ABOUT_USER = By.id("hook_Block_AboutUserSummaryEditable");
    private static final By USER_PROFILE_INTERESTS = By.id("hook_Block_UserProfileInterests");
    private static final By CHANGE_OWN_DATA_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile&cmd=PopLayer')]");

    public AboutProfilePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Summary about user is missing", isElementPresent(SUMMARY_ABOUT_USER));
        Assert.assertTrue("User profile interests are missing", isElementPresent(USER_PROFILE_INTERESTS));
        Assert.assertTrue("Change own data button is missing", isElementPresent(CHANGE_OWN_DATA_BTN));
    }

    public void clickChangeOwnData() {
        click(CHANGE_OWN_DATA_BTN);
    }
}
