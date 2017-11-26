package core.ChangeSurname;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutProfilePage extends HelperBase{

    public AboutProfilePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public void clickChangeOwnData() {
        click(By.xpath(".//*[@class='user-profile_lk-o' and contains(@hrefattrs,'st.cmd=userProfile&cmd=PopLayer')]"));
    }
}
