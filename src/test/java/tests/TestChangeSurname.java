package tests;

import core.*;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class TestChangeSurname extends TestBase {

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
        new LoginMainPage(driver).doLogin(new TestBot(LOGIN, PASSWORD));
        UserMainPage mainPage = new UserMainPage(driver);
        String oldSurname = mainPage.getSurname();
        mainPage.clickFullName();
        new ProfilePage(driver).clickChangeData();
        new AboutProfilePage(driver).clickChangeOwnData();
        ChangeSurnamePage csp = new ChangeSurnamePage(driver);
        String newSurname = generateNewSurname();
        csp.typeNewSurname(newSurname);
        csp.clickSaveNewProfileInfo();
        csp.clickCloseButton();
        csp.moveToUserMainPage();
        String getSurname = mainPage.checkSurname(oldSurname, newSurname);
        Assert.assertTrue("New surname is not equals generated surname", newSurname.equals(getSurname));
    }

}
