package core.WriteMessage;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MessagePage extends HelperBase {

    private static final By LIST_OF_MESSAGES = By.id("msg_dialogs_list_scroller");
    private static final By CONVERSATION_PROMPTED = By.id("conversationPrompted");
    private static final By UPPER_DIALOG = By.cssSelector(".chats_i:first-child .chats_i_ovr");
    private static final By SEND_MESSAGE_BTN = By.cssSelector(".button-pro.comments_add-controls_save");
    private static final By MESSAGE_AREA = By.cssSelector(".comments_add_form .comments_add-ceditable[name=\"st.txt\"]");
    private static final By MESSAGES = By.cssSelector(".js-copy-text");
    //private static final By MESSAGES = By.cssSelector(".js-copy-text span");

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
        Assert.assertFalse("Send button is not visible", isElementVisible(SEND_MESSAGE_BTN));
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

        // устанавливаем задержку, что @SEND_MESSAGE_BTN успела отобразиться
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(SEND_MESSAGE_BTN));

        // проверяем наличие и видимость кнопки "отправить"
        Assert.assertTrue("Send button is missing", isElementPresent(SEND_MESSAGE_BTN));
        Assert.assertTrue("Send button is not visible", isElementVisible(SEND_MESSAGE_BTN));
        // кликаем по кнопке "отправить"
        click(SEND_MESSAGE_BTN);
    }

    public void checkMessage() {
/*
        // устанавливаем задержку, что @MESSAGES успела отобразиться
        new WebDriverWait(driver, 1000)
                .until(ExpectedConditions.visibilityOfElementLocated(MESSAGES));
*/

        /*new WebDriverWait(driver, 50)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(MESSAGES));*/

         Assert.assertTrue("messages is missing", isElementPresent(MESSAGES));
         Assert.assertTrue("messages is not visible", isElementVisible(MESSAGES));
        // список всех сообщений
        List<WebElement> list = driver.findElements(MESSAGES);
        int size = list.size();
        System.out.println("size of list webelements = " + size);

        for (int j = 0; j < size; j++) {
            System.out.println(j + " elem = " + list.get(j).getText());
        }

        System.out.println("\n\n\n");

        // взяли отправленное сообщение со странички
        String getSendMessage = list.get(list.size() - 1).getText();

        System.out.println("get send message  =" + getSendMessage);
        System.out.println("generated message = " + message);

        // сравнили "что отправили" и "что взяли"
        Assert.assertTrue("Send message is not equals generated message", this.message.equals(getSendMessage));
    }
}
