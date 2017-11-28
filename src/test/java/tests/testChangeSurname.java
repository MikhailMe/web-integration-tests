package tests;

import core.ChangeSurname.*;
import model.TestBot;
import org.junit.Test;

public class testChangeSurname extends TestBase {

    private static final String NEW_SURNAME = "Автотестов";

    @Test
    public void changeSurnameTest() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        UserMainPage mainPage = new UserMainPage(driver);
        mainPage.clickFullName();
        new ProfilePage(driver).clickChangeData();
        new AboutProfilePage(driver).clickChangeOwnData();
        ChangeSurnamePage csp = new ChangeSurnamePage(driver);
        csp.typeNewSurname(NEW_SURNAME);
        csp.clickSaveNewProfileInfo();
        // TODO need to add check a new surname
    }

}
