package com.epam.cdpBdd.ui.pages;

import com.epam.cdpBdd.businessObject.users.User;
import com.epam.cdpBdd.utils.UtilsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;

public class ComposeMessagePage {
    private String uniqueMessageTitle;
    private WebDriver driver;

    @FindBy(xpath = "//textarea")
    private WebElement inputEmail;

    @FindBy (name = "subjectbox")
    private WebElement inputTitle;

    @FindBy (css = "div.editable")
    private WebElement inputMessageBody;

    @FindBy (xpath = "//*[contains(text(),'Send')]")
    private WebElement buttonSend;

    @FindBy(xpath = "//div[contains(text(), 'Your message has been sent')]")
    private WebElement butterBar;

    public ComposeMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendSampleMessage (WebDriver driver, User user){
        String messageTitle = "Should be spam, " + new Date().toString(); //to ensure it's unique for multiple tests
        String messageBody = "Spam Spam Spammy Spam";

        inputEmail.sendKeys(user.getUsername() + "@gmail.com ");
        inputTitle.sendKeys(messageTitle);
        inputMessageBody.click();
        inputMessageBody.sendKeys(messageBody);
        buttonSend.click();
        UtilsMethods.getWait().until(ExpectedConditions.elementToBeClickable(butterBar));
        uniqueMessageTitle = messageTitle;
        System.out.println("Message is sent, unique title is: " + messageTitle);
    }

    public String getUniqueMessageTitle() {
        return uniqueMessageTitle;
    }
}
