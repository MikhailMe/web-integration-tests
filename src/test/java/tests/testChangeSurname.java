package tests;

import core.ChangeSurname.*;
import model.LoginMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class testChangeSurname extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";
    private String oldSurname;
    private String newSurname;
    private static final By NAME = By.cssSelector(".mctc_name_tx");

    private String generateNewSurname() {
        int surnameLength = 15;
        char[] chars = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
        StringBuilder newSurname = new StringBuilder();
        for (int i = 0; i < surnameLength; i++)
            newSurname.append(chars[new Random().nextInt(chars.length)]);
        return newSurname.toString();
    }

    private void checkSurname() {
        Assert.assertFalse("Old surname equals new surname", oldSurname.equals(newSurname));
        String getSurname = driver.findElement(NAME).getText().split(" ")[1];
        Assert.assertTrue("New surname is not equals new surname", newSurname.equals(getSurname));
    }

    @Test
    public void changeSurnameTest() throws Exception {
        // залогонились
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        // перешли на главную страничку
        UserMainPage mainPage = new UserMainPage(driver);
        // запомнили старую фамилию
        oldSurname = mainPage.getSurname();
        // кликнули по фамилии
        mainPage.clickFullName();
        // кликнули по кнопке "Редактировать личные данные"
        new ProfilePage(driver).clickChangeData();
        // кликнули ещё раз по кнопке "Редактировать личные данные", но уже на другой страничке
        new AboutProfilePage(driver).clickChangeOwnData();
        // перешли на страничку редактирования личных данных
        ChangeSurnamePage csp = new ChangeSurnamePage(driver);
        // сгенерировали новую фамилию и запомнили её
        newSurname = generateNewSurname();
        // в поле "фамилия" ввели новую фамилию
        csp.typeNewSurname(newSurname);
        // кликнули по кнопке сохранения
        csp.clickSaveNewProfileInfo();
        // кликнули по кнопке "закрыть" на уведомлении об изменении
        csp.clickCloseButton();
        // перешли на главную страничку
        csp.moveToUserMainPage();
        // проверили изменение фамилии
        checkSurname();
    }

}
