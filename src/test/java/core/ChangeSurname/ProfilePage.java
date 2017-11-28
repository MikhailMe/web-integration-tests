package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends HelperBase {

    private static final By ABOUT_USER = By.id("hook_Block_AboutUser");
    private static final By CHANGE_BTN = By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile')]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Area about user is missing", isElementPresent(ABOUT_USER));
        Assert.assertTrue("Change button is missing", isElementPresent(CHANGE_BTN));
    }

    public void clickChangeData() {
        click(CHANGE_BTN);
    }
}
