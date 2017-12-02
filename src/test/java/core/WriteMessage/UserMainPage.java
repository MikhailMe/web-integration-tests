package core.WriteMessage;

import model.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

    private static final By LIST_OF_MESSAGES = By.id("msg_dialogs_list_scroller");
    private static final By CONVERSATION_PROMPTED = By.id("conversationPrompted");
    private static final By MESSAGES_ICON = By.xpath(".//*[@class='toolbar_nav_a toolbar_nav_a__messa h-mod']");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        // проверяем наличие
        checkPresentElementsOnUserMainPage();
        // проверяем видимость
        checkVisibilityElementsOnUserMainPage();
    }

    public void clickMessages() {
        // ещё раз проверили наличие иконки "сообщения"
        Assert.assertTrue("Messages icon is missing", isElementPresent(MESSAGES_ICON));
        Assert.assertTrue("Messages icon is not visible", isElementVisible(MESSAGES_ICON));
        // кликнули по иконке
        click(MESSAGES_ICON);
        // проверяем, что перешли на страничку "сообщения"
        Assert.assertTrue("List of messages is missing", isElementPresent(LIST_OF_MESSAGES));
        Assert.assertTrue("Conversation prompted is missing", isElementPresent(CONVERSATION_PROMPTED));
    }


}
