package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeSurnamePage extends HelperBase {

    private static final By EDIT_USER_PROFILE_FORM = By.id("hook_Form_PopLayerEditUserProfileNewForm");
    private static final By SAVE_NEW_PROFILE_INFO_BTN = By.id("hook_FormButton_button_savePopLayerEditUserProfileNew");
    private static final By SURNAME = By.id("field_surname");

    public ChangeSurnamePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Edit form is missing", isElementPresent(EDIT_USER_PROFILE_FORM));
        Assert.assertTrue("Surname field is missing", isElementPresent(SURNAME));
    }

    public void typeNewSurname(String newSurname) {
        type(newSurname, SURNAME);
    }

    public void clickSaveNewProfileInfo() {
        click(SAVE_NEW_PROFILE_INFO_BTN);
    }


}
