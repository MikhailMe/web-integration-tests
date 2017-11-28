package tests;

import core.AddStatus.LoginMainPage;
import core.AddStatus.PostPage;
import core.AddStatus.UserMainPage;
import model.TestBot;
import org.junit.Test;


public class testAddStatus extends TestBase {

    private static final String NEW_STATUS = "I like auto-tests!";

    @Test
    public void addStatusTest() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        new UserMainPage(driver).clickPost();
        PostPage postPage = new PostPage(driver);
        postPage.typeStatus(NEW_STATUS);
        postPage.clickShareStatus();
        // TODO need to add a check of the status message
    }
}
