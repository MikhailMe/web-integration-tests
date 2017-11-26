package core.ChangeSurname;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeSurnamePage extends HelperBase{

    public ChangeSurnamePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public void typeNewSurname(String newSurname) {
        type(newSurname, By.id("field_surname"));
    }

    public void clickSaveNewSurname() {
        click(By.id("hook_FormButton_button_savePopLayerEditUserProfileNew"));
    }


}
