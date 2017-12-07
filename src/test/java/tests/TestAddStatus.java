package tests;

import core.PostPage;
import core.UserMainPage;
import core.LoginMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class TestAddStatus extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";

    private String generateNewStatus() {
        int statusLength = 20;
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder newStatus = new StringBuilder();
        for (int i = 0; i < statusLength; i++)
            newStatus.append(chars[new Random().nextInt(chars.length)]);
        return newStatus.toString();
    }

    @Test
    public void addStatusTest() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.clickPost();
        PostPage postPage = new PostPage(driver);
        postPage.clickWritingArea();
        String newStatus = generateNewStatus();
        postPage.typeStatus(newStatus);
        postPage.clickShareStatus();
        userMainPage.clickNotes();
        String getStatus = userMainPage.getStatus();
        Assert.assertTrue("New status is not equals generated status", newStatus.equals(getStatus));
    }
}
