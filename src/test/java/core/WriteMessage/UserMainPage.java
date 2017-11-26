package core.WriteMessage;

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

    public void clickMessages() {
        click(By.xpath(".//*[@class='toolbar_nav_a toolbar_nav_a__messa h-mod']"));
    }


}
