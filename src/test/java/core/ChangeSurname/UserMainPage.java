package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

    private static final By MIDDLE_COLUMN = By.id("hook_Block_MiddleColumnTopCard");
    private static final By LEFT_COLUMN = By.id("hook_Block_LeftColumnTopCardUser");
    private static final By POSTING_FORM = By.id("hook_Block_PostingForm");
    private static final By FULL_NAME = By.xpath(".//*[@class='mctc_nameLink']");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Middle column is missing", isElementPresent(MIDDLE_COLUMN));
        Assert.assertTrue("Left column is missing", isElementPresent(LEFT_COLUMN));
        Assert.assertTrue("Posting form is missing", isElementPresent(POSTING_FORM));
        Assert.assertTrue("Full name is missing", isElementPresent(FULL_NAME));
    }

    public void clickFullName() {
        click(FULL_NAME);
    }
}
