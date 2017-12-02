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
    // TODO: fix Xpath status
    //*[@id="hook_Block_MainFeedsNewFeed"]
    private static final By STATUS = By.cssSelector(".mctc_name_tx");
    private String newStatus;

    private String generateNewStatus() {
        int statusLength = 20;
        char[] chars = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        StringBuilder newStatus = new StringBuilder();
        for (int i = 0; i < statusLength; i++)
            newStatus.append(chars[new Random().nextInt(chars.length)]);
        return newStatus.toString();
    }

    private String getStatus() {
        return driver.findElement(STATUS).getText();
    }

    private void checkStatus() {
        String getStatus = getStatus();
        Assert.assertTrue("New status is not equals generated status", newStatus.equals(getStatus));
    }

    @Test
    public void addStatusTest() throws Exception {
        // залогинились
        LoginMainPage loginMainPage = new LoginMainPage(driver);
        // перешли на главную страничку
        loginMainPage.doLogin(new TestBot(LOGIN, PASSWORD));
        // кликнули по области для ввода поста
        new UserMainPage(driver).clickPost();
        // перешли на страничку поста
        PostPage postPage = new PostPage(driver);
        // кликнули по области для ввода статуса
        postPage.clickWritingArea();
        // сгенерировали статус
        newStatus = generateNewStatus();
        // написали статус
        postPage.typeStatus(newStatus);
        // кликнули по кнопке "поделиться статусом"
        postPage.clickShareStatus();
        // проверили изменение статуса
        //checkStatus();
    }
}
