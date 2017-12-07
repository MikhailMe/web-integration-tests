package tests;

import core.ChangeSurname.*;
import model.LoginMainPage;
import model.TestBot;
import org.junit.Test;

import java.util.Random;

public class testChangeSurname extends TestBase {

    private static final String LOGIN = "technopolisBot13";
    private static final String PASSWORD = "technopolis16";

    private String generateNewSurname() {
        int surnameLength = 15;
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder newSurname = new StringBuilder();
        for (int i = 0; i < surnameLength; i++)
            newSurname.append(chars[new Random().nextInt(chars.length)]);
        return newSurname.toString();
    }

    @Test
    public void changeSurnameTest() throws Exception {
        // залогонились
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        // перешли на главную страничку
        UserMainPage mainPage = new UserMainPage(driver);
        // запомнили старую фамилию
        String oldSurname = mainPage.getSurname();
        // кликнули по фамилии
        mainPage.clickFullName();
        // кликнули по кнопке "Редактировать личные данные"
        new ProfilePage(driver).clickChangeData();
        // кликнули ещё раз по кнопке "Редактировать личные данные", но уже на другой страничке
        new AboutProfilePage(driver).clickChangeOwnData();
        // перешли на страничку редактирования личных данных
        ChangeSurnamePage csp = new ChangeSurnamePage(driver);
        // сгенерировали новую фамилию и запомнили её
        String newSurname = generateNewSurname();
        // в поле "фамилия" ввели новую фамилию
        csp.typeNewSurname(newSurname);
        // кликнули по кнопке сохранения
        csp.clickSaveNewProfileInfo();
        // кликнули по кнопке "закрыть" на уведомлении об изменении
        csp.clickCloseButton();
        // перешли на главную страничку
        csp.moveToUserMainPage();
        // проверили изменение фамилии
        mainPage.checkSurname(oldSurname, newSurname);
    }

}
