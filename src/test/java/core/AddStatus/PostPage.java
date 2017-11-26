package core.AddStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PostPage extends HelperBase{

    //private static final By CREATE_NEW_POST = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");

    public PostPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
       /* //пример использования метода из HelperBase
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return isElementPresent(CREATE_NEW_POST);
            }
        });

        //пример использования класса ExpectedConditions
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_POST));*/
    }

    public void typeStatus(String post) {
        type(post, By.id("posting_form_text_field"));
    }

    public void clickShareStatus() {
        click(By.id("gpf_4958604292"));
    }
}
