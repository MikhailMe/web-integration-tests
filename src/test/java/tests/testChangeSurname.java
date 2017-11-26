package tests;

import core.ChangeSurname.*;
import core.TestBase;
import model.TestBot;
import org.junit.Test;

public class testChangeSurname extends TestBase {

    @Test
    public void addStatusTest() throws Exception{
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        new UserMainPage(driver).clickSurname();
        new ProfilePage(driver).clickChangeData();
        new AboutProfilePage(driver).clickChangeOwnData();
        ChangeSurnamePage csp = new ChangeSurnamePage(driver);
        csp.typeNewSurname("Автотестов");
        csp.clickSaveNewSurname();
        // TODO ADD CHECK
    }

}
