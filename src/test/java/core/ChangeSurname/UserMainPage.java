package core.ChangeSurname;

import core.Group.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase{

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        //todo
    }

    public void clickSurname() {
        click(By.xpath(".//*[@class='mctc_nameLink']"));
    }
}
