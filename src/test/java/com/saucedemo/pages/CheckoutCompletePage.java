package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage{
    @FindBy (xpath = "//h2")
    public WebElement successMessage;

    public void assertSuccessMessage(String expectedMessage){
        Assert.assertEquals(successMessage.getText(),expectedMessage);
    }
}
