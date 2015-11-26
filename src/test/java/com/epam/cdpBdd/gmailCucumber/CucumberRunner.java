package com.epam.cdpBdd.gmailCucumber;

import com.epam.cdpBdd.core.webdriver.factory.ChromeDriverSingleton;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)
public class CucumberRunner {
    @Before
    public static void initSelenium(){
        ChromeDriverSingleton.getDecoratedWebDriverInstance();
    }

    @After
    public static void closeSelenium(){
        ChromeDriverSingleton.closeDriver();
    }
}

