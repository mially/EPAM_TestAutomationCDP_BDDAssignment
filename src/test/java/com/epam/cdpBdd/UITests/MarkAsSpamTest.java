package com.epam.cdpBdd.UITests;

import com.epam.cdpBdd.businessObject.users.UserCreator;
import com.epam.cdpBdd.core.webdriver.factory.ChromeDriverSingleton;
import com.epam.cdpBdd.ui.pages.*;
import com.epam.cdpBdd.businessObject.users.User;
import com.epam.cdpBdd.utils.UtilsMethods;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class MarkAsSpamTest {
    protected WebDriver driver;

    @Before
    public void setupDecoratedDriver() {
        //driver = FirefoxDriverSingleton.getDecoratedWebDriverInstance();
        driver = ChromeDriverSingleton.getDecoratedWebDriverInstance();
    }

    @Test
    public void MarkAsSpamTestRun(){
        UtilsMethods wait = new UtilsMethods(driver);
        User user1 = UserCreator.createUser1();
        User user2 = UserCreator.createUserWithCredentials("gmbdaily003", "gmbdaily003mially");
        InboxPage inboxPage;

        String messageTitle01, messageTitle02;
        boolean isMessageInSpam = false;

        //send message from user1 to user2
        inboxPage = user1.loginToGmail(driver);
        messageTitle01 = inboxPage.createMessageTo(driver, user2); //save unique message title to find message later
        inboxPage.logout(driver);

        //find message in Inbox and mark as spam
        inboxPage = user2.loginToGmail(driver);
        inboxPage.searchForMessageInInboxAndMarkAsSpam(driver, messageTitle01);
        inboxPage.logout(driver);

        //send message from user1 to user2
        inboxPage = user1.loginToGmail(driver); //save unique message title to find message later
        messageTitle02 = inboxPage.createMessageTo(driver, user2);
        inboxPage.logout(driver);

        //find message in Spam and un-spam it (revert the state)
        inboxPage = user2.loginToGmail(driver);
        isMessageInSpam = inboxPage.searchForMessageInSpamAndUnspam(driver, messageTitle02);
        inboxPage.logout(driver);

        driver.quit();
        Assert.assertTrue(isMessageInSpam);
    }

    @After
    public void tearDown(){
        //FirefoxDriverSingleton.closeDriver();
        ChromeDriverSingleton.closeDriver();
    }

}


