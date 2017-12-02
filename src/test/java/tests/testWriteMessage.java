package tests;

import core.WriteMessage.MessagePage;
import core.WriteMessage.UserMainPage;
import model.LoginMainPage;
import model.TestBot;
import org.junit.Test;

public class testWriteMessage extends TestBase {

    private static final String message = "I like write auto-tests ;)";

    @Test
    public void writeMessageTest() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        new UserMainPage(driver).clickMessages();
        MessagePage messagePage = new MessagePage(driver);
        messagePage.clickUpperDialog();
        messagePage.typeMessage(message);
        messagePage.clickSend();
        // TODO need to add a check of sent message
    }
}
