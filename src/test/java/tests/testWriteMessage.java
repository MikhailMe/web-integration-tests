package tests;

import core.WriteMessage.MessagePage;
import core.WriteMessage.UserMainPage;
import model.LoginMainPage;
import model.TestBot;
import org.junit.Test;

import java.util.Random;


/**
 * This test is suitable only for users who have at least one dialog!!!
 */
public class testWriteMessage extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";

    private String generateNewMessage() {
        int messageLength = new Random().nextInt(30) + 10;
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789 ".toCharArray();
        StringBuilder newMessage = new StringBuilder();
        for (int i = 0; i < messageLength; i++)
            newMessage.append(chars[new Random().nextInt(chars.length)]);
        return newMessage.toString();
    }

    @Test
    public void writeMessageTest() throws Exception {
        // залогонились
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        // перешли на главную страничку
        new UserMainPage(driver).clickMessages();
        // перешли на страничку сообщений
        MessagePage messagePage = new MessagePage(driver);
        // кликнули по верхнему диалогу
        messagePage.clickUpperDialog();
        // сгенерировали сообщение
        String message = generateNewMessage();
        // написали сообщение
        messagePage.typeMessage(message);
        // кликнули по кнопке "отправить сообщение"
        messagePage.clickSend();
        // проверили отправку сообщения
        messagePage.checkMessage();
    }
}
