package tests;

import core.AddStatus.PostPage;
import core.AddStatus.UserMainPage;
import model.LoginMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class testAddStatus extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";
    private static final By STATUS = By.cssSelector(".user-statuses .feed");
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
        List<WebElement> statuses = driver.findElements(STATUS);
        int amountStatuses = statuses.size();

        /*System.out.println("size of list = " + amountStatuses);

        for (int i = 0; i < amountStatuses; i++) {
            System.out.println(i + " elem = " + statuses.get(i).getText());
            System.out.println("\n\n");
        }

        for (int i = 0; i < amountStatuses; i++) {
            String[] strings = statuses.get(i).getText().split("\n");
            System.out.println(i + "element:");
            for (int j = 0; j < strings.length; j++) {
                System.out.println(j + "string = " + strings[j]);
            }
        }*/

        return statuses.get(amountStatuses - 1).getText().split("\n")[1];
    }

    private void checkStatus() {
        String getStatus = getStatus();

        System.out.println("get status = " + getStatus);
        System.out.println("generated status = " + newStatus);

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
        //postPage.clickWritingArea();
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
