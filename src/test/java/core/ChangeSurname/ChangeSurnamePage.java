package core.ChangeSurname;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        // проверяем наличие
        Assert.assertTrue("Surname field is missing", isElementPresent(SURNAME));
        Assert.assertTrue("Edit form is missing", isElementPresent(EDIT_USER_PROFILE_FORM));
        Assert.assertTrue("Save button is missing", isElementPresent(SAVE_NEW_PROFILE_INFO_BTN));
        // проверяем видимость
        Assert.assertTrue("Surname field is not visible", isElementVisible(SURNAME));
        Assert.assertTrue("Edit form is not visible", isElementVisible(EDIT_USER_PROFILE_FORM));
        Assert.assertTrue("Save button is not visible", isElementVisible(SAVE_NEW_PROFILE_INFO_BTN));
    }

    public void typeNewSurname(String newSurname) {
        // ёще раз проверяем наличие и видимость поля "фамилия"
        Assert.assertTrue("Surname field is missing", isElementPresent(SURNAME));
        Assert.assertTrue("Surname field is not visible", isElementVisible(SURNAME));
        // пишем новую фамилию
        type(newSurname, SURNAME);
    }

    public void clickSaveNewProfileInfo() {
        // ещё раз проверяем наличие кнопки
        Assert.assertTrue("Save button is missing", isElementPresent(SAVE_NEW_PROFILE_INFO_BTN));
        Assert.assertTrue("Save button is not visible", isElementVisible(SAVE_NEW_PROFILE_INFO_BTN));
        click(SAVE_NEW_PROFILE_INFO_BTN);
        // проверяем уведомление о том, что фамилия была изменена
        Assert.assertTrue("Close button is missing", isElementPresent(CLOSE_BTN));
        Assert.assertTrue("Close button is not visible", isElementVisible(CLOSE_BTN));
    }

    public void clickCloseButton() {
        // проверяем наличие и видимость кнопки "закрыть" на уведомлении об изменении
        Assert.assertTrue("Close button is missing", isElementPresent(CLOSE_BTN));
        Assert.assertTrue("Close button is not visible", isElementVisible(CLOSE_BTN));
        // кликаем по кнопке "закрыть" на уведомлении об изменении
        click(CLOSE_BTN);
        // проверяем, что вернулись на предыдущую страничку
        Assert.assertTrue("Summary about user is missing", isElementPresent(SUMMARY_ABOUT_USER));
        Assert.assertTrue("User profile interests are missing", isElementPresent(USER_PROFILE_INTERESTS));
        Assert.assertTrue("Change own data button is missing", isElementPresent(CHANGE_OWN_DATA_BTN));
    }


    public void moveToUserMainPage() {
        // проверяем наличие и видимость кнопки возврата к главной страничке
        Assert.assertTrue("ToProfile button is missing", isElementPresent(TO_MAIN_PAGE_BTN));
        Assert.assertTrue("ToProfile button is not visible", isElementVisible(TO_MAIN_PAGE_BTN));
        // кликаем по кнопке
        click(TO_MAIN_PAGE_BTN);
        // проверяем, что перешли на главную страничку
        checkPresentElementsOnUserMainPage();
    }
}
