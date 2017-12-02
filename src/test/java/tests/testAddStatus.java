package tests;

import core.AddStatus.PostPage;
import core.AddStatus.UserMainPage;
import model.LoginMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class testAddStatus extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";
    private static final By NAME = By.cssSelector(".mctc_name_tx");

    private String generateNewStatus() {
        int statusLength = 20;
        char[] chars = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        StringBuilder newStatus = new StringBuilder();
        for (int i = 0; i < statusLength; i++)
            newStatus.append(chars[new Random().nextInt(chars.length)]);
        return newStatus.toString();
    }

    // save prev and check
    private void checkStatus() {
        String newStatus = driver.findElement(NAME).getText();
        Assert.assertEquals("I like auto-tests!", newStatus);
    }

    @Test
    public void addStatusTest() throws Exception {
        LoginMainPage loginMainPage = new LoginMainPage(driver);
        loginMainPage.doLogin(new TestBot(LOGIN, PASSWORD));
        new UserMainPage(driver).clickPost();
        PostPage postPage = new PostPage(driver);
        postPage.clickWritingArea();
        postPage.typeStatus(generateNewStatus());
        postPage.clickShareStatus();
        checkStatus();
    }
}
