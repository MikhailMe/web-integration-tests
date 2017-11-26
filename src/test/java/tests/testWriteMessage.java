package tests;

import core.TestBase;
import core.WriteMessage.LoginMainPage;
import core.WriteMessage.MessagePage;
import core.WriteMessage.UserMainPage;
import model.TestBot;
import org.junit.Test;

public class testWriteMessage extends TestBase {

    @Test
    public void addStatusTest() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot12", "technopolis16"));
        new UserMainPage(driver).clickMessages();
        MessagePage messagePage = new MessagePage(driver);
        messagePage.clickDialog();
        messagePage.typeMessage("hello");
        messagePage.clickSend();
        // TODO ADD CHECK
    }
}