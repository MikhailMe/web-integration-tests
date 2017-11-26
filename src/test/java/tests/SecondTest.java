package tests;

import core.Group.GroupMainPage;
import core.Group.LoginMainPage;
import core.Group.UserMainPage;
import core.TestBase;
import model.TestBot;
import org.junit.Test;

public class SecondTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        new UserMainPage(driver).clickGroupsOnToolbar();
        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName("Group");
        groupMainPage.clickCreateButton();
        //todo не хватает проверки
    }
}