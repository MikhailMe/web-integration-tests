package core.AddStatus;

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

    public void clickPost() {
        //*[@id="hook_Block_MiddleColumnTopCardUser"]/div/div/div[1]/div/span[1]/a/h1
        click(By.xpath(".//*[@class='input_placeholder']"));
    }
}
