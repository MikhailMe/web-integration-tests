package core.Group;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

    private static final By MIDDLE_COLUMN = By.id("hook_Block_MiddleColumnTopCard");
    private static final By LEFT_COLUMN = By.id("hook_Block_LeftColumnTopCardUser");
    private static final By POSTING_FORM = By.id("hook_Block_PostingForm");
    private static final By GROUPS_ON_TOOLBAR = By.xpath(".//*[@class='mctc_navMenuSec' and contains(@href,'groups')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Middle column is missing", isElementPresent(MIDDLE_COLUMN));
        Assert.assertTrue("Left column is missing", isElementPresent(LEFT_COLUMN));
        Assert.assertTrue("Posting form is missing", isElementPresent(POSTING_FORM));
    }

    public void clickGroupsOnToolbar() {
        click(GROUPS_ON_TOOLBAR);
    }
}
