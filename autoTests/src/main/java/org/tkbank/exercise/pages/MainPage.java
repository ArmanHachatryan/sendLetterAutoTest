package org.tkbank.exercise.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tkbank.exercise.constants.Constant;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[text()='Написать']")
    private WebElement writeButton;

    @FindBy(xpath = "//div[@aria-label='Текст письма']")
    private WebElement textField;

    @FindBy(xpath = "//input[contains(@aria-label, 'Кому')]")
    private WebElement recipientField;

    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement sendButton;

    public MainPage() {
        driver.get(Constant.GMAIL_RU);
        PageFactory.initElements(driver, this);
    }

    public MainPage writeMessage(String recipient, String message) {
        writeButton.click();
        recipientField.click();
        recipientField.sendKeys(recipient);
        textField.click();
        textField.sendKeys(message);
        sendButton.click();
        return this;
    }
}
