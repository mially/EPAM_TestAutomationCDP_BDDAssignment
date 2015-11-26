package com.epam.cdpBdd.gmailCucumber.steps;

import com.epam.cdpBdd.businessObject.users.User;
import com.epam.cdpBdd.businessObject.users.UserCreator;
import com.epam.cdpBdd.core.webdriver.factory.ChromeDriverSingleton;
import com.epam.cdpBdd.ui.pages.InboxPage;
import com.epam.cdpBdd.ui.pages.SignInPage;
import com.epam.cdpBdd.utils.UtilsMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class LoginStepsDef {
    WebDriver driver = ChromeDriverSingleton.getDecoratedWebDriverInstance();
    InboxPage inboxPage;

    @Given("^I navigate to Gmail$")
    public void iNavigateToGmail() throws Throwable {
        UtilsMethods wait = new UtilsMethods(driver);
        driver.navigate().to("https://accounts.google.com/AddSession?continue=https://mail.google.com/");
    }

    @When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\" and log in$")
    public void iEnterUsernameAndPasswordAndLogIn(String username, String password){
        User newUser = UserCreator.createUserWithCredentials(username, password);
        inboxPage = newUser.loginToGmail(driver);
    }

    @Then("^Gmail inbox page should be loaded for \"([^\"]*)\"$")
    public void gmailInboxPageShouldBeLoaded(String username){
        assertThat(driver.getTitle(), containsString("Inbox"));
        assertThat(driver.getTitle(), containsString(username));
    }

}
