package core.WriteMessage;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage extends HelperBase {

    private static final By LIST_OF_MESSAGES = By.id("msg_dialogs_list_scroller");
    private static final By UPPER_DIALOG = By.cssSelector(".chats_i:first-child .chats_i_ovr");
    private static final By CONVERSATION_PROMPTED = By.id("conversationPrompted");
    private static final By MESSAGE_AREA = By.cssSelector(".comments_add_form .comments_add-ceditable[name=\"st.txt\"]");
    private static final By SEND_MESSAGE_BTN = By.cssSelector(".button-pro.comments_add-controls_save");

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("List of messages is missing", isElementPresent(LIST_OF_MESSAGES));
        Assert.assertTrue("Conversation prompted is missing", isElementPresent(CONVERSATION_PROMPTED));
    }

    public void clickUpperDialog() {
        // получать сюда инт и говорить какому диалогу отправить сообщуху
        // проверить отоброжаение и видимость
        click(UPPER_DIALOG);
        // проверить то что нажали, то есть начали отображаться элементы, которые видны после клика
    }

    public void typeMessage(String message) {
        type(message, MESSAGE_AREA);
    }

    public void clickSend() {
        click(SEND_MESSAGE_BTN);
    }
}
