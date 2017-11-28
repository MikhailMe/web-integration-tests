package tests;

import core.Group.GroupMainPage;
import core.Group.LoginMainPage;
import core.Group.UserMainPage;
import model.TestBot;
import org.junit.Test;

public class testCreateGroup extends TestBase {

    private static final String NEW_GROUP_NAME = "new group";

    @Test
    public void testGroupCreation() throws Exception {
        new LoginMainPage(driver).doLogin(new TestBot("technopolisBot11", "technopolis16"));
        new UserMainPage(driver).clickGroupsOnToolbar();
        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateGroup();
        groupMainPage.clickInterestGroup();
        groupMainPage.typeGroupName(NEW_GROUP_NAME);
        groupMainPage.clickCreateButton();
        // TODO need to add check a new group name
    }
}
