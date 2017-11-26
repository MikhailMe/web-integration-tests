package core.WriteMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage extends HelperBase{

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }


    public void clickDialog() {
        //PRIVATE_572471423820;
        click(By.xpath(".//*[contains(@data-id,'PRIVATE_572471423820')]"));
        //click(By.xpath(".//*[contains(@data-id,'st.layer.cmd=PopLayerCreateAltGroup')]"));
        //click(By.xpath(".//*[@class='chats_i_ovr']"));
    }

    public void typeMessage(String message) {
        type(message, By.xpath(".//*[contains(@class,'chat_write js-chat_write')]"));
    }

    public void clickSend() {
        click(By.xpath(".//*[contains(@class,'button-pro comments_add-controls_save')]"));
    }
}
