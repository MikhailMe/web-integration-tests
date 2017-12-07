package core;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserMainPage extends HelperBase {

    private static final By WRITING_AREA = By.id("posting_form_text_field");
    private static final By POST_AREA = By.xpath(".//*[@class='input_placeholder']");
    private static final By NOTES = By.id("hook_Block_MiddleColumnTopCard_MenuUser");
    private static final By USER_STATUSES = By.id("hook_Block_UserStatusesMRB");
    private static final By MIDDLE_COLUMN = By.id("hook_Block_MiddleColumnTopCard");
    private static final By LEFT_COLUMN = By.id("hook_Block_LeftColumnTopCardUser");
    private static final By POSTING_FORM = By.id("hook_Block_PostingForm");
    private static final By LIST_OF_MESSAGES = By.id("msg_dialogs_list_scroller");
    private static final By CONVERSATION_PROMPTED = By.id("conversationPrompted");
    private static final By MESSAGES_ICON = By.xpath(".//*[@class='toolbar_nav_a toolbar_nav_a__messa h-mod']");
    private static final By FULL_NAME = By.xpath(".//*[@class='mctc_nameLink']");
    private static final By ABOUT_USER = By.id("hook_Block_AboutUser");
    private static final By CHANGE_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile')]");
    private static final By NAME = By.cssSelector(".mctc_name_tx");
    private static final By STATUS = By.cssSelector(".user-statuses .feed");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Middle column is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(MIDDLE_COLUMN)));
        Assert.assertTrue("Left column is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(LEFT_COLUMN)));
        Assert.assertTrue("Posting form is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(POSTING_FORM)));
        Assert.assertTrue("Post area is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(POST_AREA)));
    }

    public UserMainPage clickPost() {
        Assert.assertTrue("Post area is not visible", isElementVisible(POST_AREA));
        click(POST_AREA);
        Assert.assertTrue("Writing area is not visible", isElementVisible(WRITING_AREA));
        return this;
    }

    public void clickNotes() {
        Assert.assertTrue("Notes are not visible", isElementVisible(NOTES));
        click(NOTES);
        Assert.assertTrue("User statuses are not visible", isElementVisible(USER_STATUSES));
    }

    public void clickMessages() {
        Assert.assertTrue("Messages icon is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(MESSAGES_ICON)));
        click(MESSAGES_ICON);
        Assert.assertTrue("List of messages is missing",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementPresent(LIST_OF_MESSAGES)));
        Assert.assertTrue("Conversation prompted is missing",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementPresent(CONVERSATION_PROMPTED)));
    }

    public void clickFullName() {
        Assert.assertTrue("Full name is not visible", isElementVisible(FULL_NAME));
        click(FULL_NAME);
        Assert.assertTrue("Area about user is missing", isElementVisible(ABOUT_USER));
        Assert.assertTrue("Change button is missing", isElementVisible(CHANGE_BTN));
    }

    public String getSurname() {
        Assert.assertTrue("Name is not visible", isElementVisible(NAME));
        return driver.findElement(NAME).getText();
    }

    public String checkSurname(String oldSurname, String newSurname) {
        Assert.assertFalse("Old surname equals new surname", oldSurname.equals(newSurname));
        return driver.findElement(NAME).getText().split(" ")[1];

    }

    public String getStatus() {
        List<WebElement> statuses = driver.findElements(STATUS);
        int amountStatuses = statuses.size();
        return statuses.get(amountStatuses - 1).getText().split("\n")[1];
    }

}
