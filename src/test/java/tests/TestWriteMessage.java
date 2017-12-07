package tests;

import core.UserMainPage;
import core.MessagePage;
import core.LoginMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class TestWriteMessage extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";

    private String generateNewMessage() {
        int messageLength = new Random().nextInt(30) + 10;
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder newMessage = new StringBuilder();
        for (int i = 0; i < messageLength; i++)
            newMessage.append(chars[new Random().nextInt(chars.length)]);
        return newMessage.toString();
    }

    @Test
    public void writeMessageTest() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        new UserMainPage(driver).clickMessages();
        MessagePage messagePage = new MessagePage(driver);
        messagePage.clickUpperDialog();
        String message = generateNewMessage();
        messagePage.typeMessage(message);
        messagePage.clickSend();
        String getSendMessage = messagePage.getMessage();
        Assert.assertTrue("Send message is not equals generated message", message.equals(getSendMessage));
    }
}
