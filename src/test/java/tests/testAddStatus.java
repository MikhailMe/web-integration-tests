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
    // TODO: fix STATUS
    private static final By STATUS = By.cssSelector(".feed:first-child");
    private String newStatus;

    private String generateNewStatus() {
        int statusLength = 20;
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder newStatus = new StringBuilder();
        for (int i = 0; i < statusLength; i++)
            newStatus.append(chars[new Random().nextInt(chars.length)]);
        return newStatus.toString();
    }

    private String getStatus() {
        // TODO достать только статус, если нужно будет (зависит от @STATUS)
        return driver.findElement(STATUS).getText();
    }



    private void checkStatus() {
        String getStatus = getStatus();
        Assert.assertTrue("New status is not equals generated status", newStatus.equals(getStatus));
    }

    @Test
    public void addStatusTest() throws Exception {
        // залогинились
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        // перешли на главную страничку
        UserMainPage userMainPage = new UserMainPage(driver);
        // кликнули по области для ввода поста
        userMainPage.clickPost();
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
        // кликаем по кнопке "заметки"
        userMainPage.clickNotes();
        // проверили изменение статуса
        checkStatus();
    }
}
