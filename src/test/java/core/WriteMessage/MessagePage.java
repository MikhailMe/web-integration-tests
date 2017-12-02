package core.WriteMessage;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage extends HelperBase {

    private static final By LIST_OF_MESSAGES = By.id("msg_dialogs_list_scroller");
    private static final By CONVERSATION_PROMPTED = By.id("conversationPrompted");
    private static final By UPPER_DIALOG = By.cssSelector(".chats_i:first-child .chats_i_ovr");
    private static final By SEND_MESSAGE_BTN = By.cssSelector(".button-pro.comments_add-controls_save");
    private static final By MESSAGE_AREA = By.cssSelector(".comments_add_form .comments_add-ceditable[name=\"st.txt\"]");
    // TODO get Xpath or cssSelector for last message
    private static final By LAST_MESSAGE = By.id("");

    private String message;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем наличие
        Assert.assertTrue("List of messages is missing", isElementPresent(LIST_OF_MESSAGES));
        Assert.assertTrue("Conversation prompted is missing", isElementPresent(CONVERSATION_PROMPTED));
        // проверяем видимость
        Assert.assertTrue("List of messages is not visible", isElementVisible(LIST_OF_MESSAGES));
        Assert.assertTrue("Conversation prompted is not visible", isElementVisible(CONVERSATION_PROMPTED));
    }

    public void clickUpperDialog() {
        // проверяем наличие и видимость верхнего диалога
        Assert.assertTrue("Upper dialog is missing", isElementPresent(UPPER_DIALOG));
        Assert.assertTrue("Upper dialog is not visible", isElementVisible(UPPER_DIALOG));
        // кликаем по верхнему диалогу
        click(UPPER_DIALOG);
        // проверяем, что открылся верхний диалог - отображается кнопка "отправить"
        Assert.assertTrue("Send button is missing", isElementPresent(SEND_MESSAGE_BTN));
        Assert.assertTrue("Send button is not visible", isElementVisible(SEND_MESSAGE_BTN));
    }

    public void typeMessage(String message) {
        // запоминаем сообщение
        this.message = message;
        // проверяем наличие и видимость области для ввода сообщения
        Assert.assertTrue("Message area is missing", isElementPresent(MESSAGE_AREA));
        Assert.assertTrue("Message area is not visible", isElementVisible(MESSAGE_AREA));
        // написали сообщение
        type(message, MESSAGE_AREA);
    }

    public void clickSend() {
        // проверяем наличие и видимость кнопки "отправить"
        Assert.assertTrue("Send button is missing", isElementPresent(SEND_MESSAGE_BTN));
        Assert.assertTrue("Send button is not visible", isElementVisible(SEND_MESSAGE_BTN));
        // кликаем по кнопке "отправить"
        click(SEND_MESSAGE_BTN);
    }

    public void checkMessage() {
        // взяли отправленное сообщение со странички
        String getSendMessage = driver.findElement(LAST_MESSAGE).getText();
        // сравнили "что отправили" и "что взяли"
        Assert.assertTrue("Send message is not equals generated message", this.message.equals(getSendMessage));
    }
}
