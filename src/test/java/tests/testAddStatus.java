package tests;

import core.AddStatus.LoginMainPage;
import core.AddStatus.PostPage;
import core.TestBase;
import core.AddStatus.UserMainPage;
import model.TestBot;
import org.junit.Test;


public class testAddStatus extends TestBase {

    @Test
    public void addStatusTest() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        new UserMainPage(driver).clickPost();
        PostPage postPage = new PostPage(driver);
        postPage.typeStatus("I like autotests!");
        postPage.clickShareStatus();
        // TODO ADD CHECK
    }
}
