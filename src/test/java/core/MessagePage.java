package core;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessagePage extends HelperBase {

    private static final By LIST_OF_MESSAGES = By.id("msg_dialogs_list_scroller");
    private static final By CONVERSATION_PROMPTED = By.id("conversationPrompted");
    private static final By UPPER_DIALOG = By.cssSelector(".chats_i:first-child .chats_i_ovr");
    private static final By SEND_MESSAGE_BTN = By.cssSelector(".button-pro.comments_add-controls_save");
    private static final By MESSAGE_AREA = By.cssSelector(".comments_add_form .comments_add-ceditable[name=\"st.txt\"]");
    private static final By MESSAGES = By.cssSelector(".js-copy-text");
    private static final int AMOUNT_OF_VISIBLE_MESSAGES = 21;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("List if messages is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(LIST_OF_MESSAGES)));
        Assert.assertTrue("Conversation prompted is not visible",
                new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> isElementVisible(CONVERSATION_PROMPTED)));
    }

    public MessagePage clickUpperDialog() {
        Assert.assertTrue("Upper dialog is not visible", isElementVisible(UPPER_DIALOG));
        click(UPPER_DIALOG);
        Assert.assertFalse("Send button is not visible", isElementVisible(SEND_MESSAGE_BTN));
        return this;
    }

    public MessagePage typeMessage(String message) {
        Assert.assertTrue("Message area is not visible", isElementVisible(MESSAGE_AREA));
        type(message, MESSAGE_AREA);
        return this;
    }

    public MessagePage clickSend() {
        Assert.assertTrue("Send button is not visible", isElementVisible(SEND_MESSAGE_BTN));
        click(SEND_MESSAGE_BTN);
        return this;
    }

    public String getMessage() {
        List<WebElement> list = driver.findElements(MESSAGES);
        int i = 0;
        while (list.size() != AMOUNT_OF_VISIBLE_MESSAGES || i != 100) {
            list = driver.findElements(MESSAGES);
            i++;
        }
        return list.get(list.size() - 1).getText();
    }
}
