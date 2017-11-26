package core.ChangeSurname;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends HelperBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public void clickChangeData() {
        click(By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile')]"));
    }
}
