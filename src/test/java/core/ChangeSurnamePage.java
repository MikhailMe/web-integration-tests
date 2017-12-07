package core;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeSurnamePage extends HelperBase {

    private static final By EDIT_USER_PROFILE_FORM = By.id("hook_Form_PopLayerEditUserProfileNewForm");
    private static final By SAVE_NEW_PROFILE_INFO_BTN = By.id("hook_FormButton_button_savePopLayerEditUserProfileNew");
    private static final By SURNAME = By.id("field_surname");
    private static final By CLOSE_BTN = By.id("buttonId_button_close");
    private static final By SUMMARY_ABOUT_USER = By.id("hook_Block_AboutUserSummaryEditable");
    private static final By USER_PROFILE_INTERESTS = By.id("hook_Block_UserProfileInterests");
    private static final By CHANGE_OWN_DATA_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile&cmd=PopLayer')]");
    private static final By TO_MAIN_PAGE_BTN = By.id("topPanelLeftCorner");

    public ChangeSurnamePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Surname field is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(SURNAME)));
        Assert.assertTrue("Edit form is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(EDIT_USER_PROFILE_FORM)));
        Assert.assertTrue("Save button is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(SAVE_NEW_PROFILE_INFO_BTN)));
    }

    public void typeNewSurname(String newSurname) {
        Assert.assertTrue("Surname field is not visible", isElementVisible(SURNAME));
        type(newSurname, SURNAME);
    }

    public void clickSaveNewProfileInfo() {
        Assert.assertTrue("Save button is not visible", isElementVisible(SAVE_NEW_PROFILE_INFO_BTN));
        click(SAVE_NEW_PROFILE_INFO_BTN);
        Assert.assertTrue("Close button is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(CLOSE_BTN)));
    }

    public void clickCloseButton() {
        Assert.assertTrue("Close button is not visible", isElementVisible(CLOSE_BTN));
        click(CLOSE_BTN);
        Assert.assertTrue("Summary about user is missing", isElementVisible(SUMMARY_ABOUT_USER));
        Assert.assertTrue("User profile interests are missing", isElementVisible(USER_PROFILE_INTERESTS));
        Assert.assertTrue("Change own data button is missing", isElementVisible(CHANGE_OWN_DATA_BTN));
    }

    public void moveToUserMainPage() {
        Assert.assertTrue("ToProfile button is not visible", isElementVisible(TO_MAIN_PAGE_BTN));
        click(TO_MAIN_PAGE_BTN);
    }
}
