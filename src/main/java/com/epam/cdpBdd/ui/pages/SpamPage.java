package com.epam.cdpBdd.ui.pages;

import com.epam.cdpBdd.utils.UtilsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SpamPage {
    private WebDriver driver;

    @FindBy(xpath = "//tbody/tr/td[6]")
    private List<WebElement> emailTitles;

    public SpamPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean searchForMessageAndUnspam(String title) {
        boolean isFound = false;
        for (WebElement element : emailTitles) {
            if (element.isDisplayed() && element.getText().contains(title)) {
                System.out.println("Message '" + title + "' found in Spam");
                isFound = true;
                element.click();
                UtilsMethods.getWait().until(ExpectedConditions.titleContains(title));
                MessagePage messagePage = new MessagePage(driver);
                messagePage.unSpamLetter();
            }
        }
        if (!isFound) {
            System.out.println("No message in Spam");
        }
        return isFound;
    }

}
