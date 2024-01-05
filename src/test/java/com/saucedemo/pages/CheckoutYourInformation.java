package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutYourInformation extends BasePage{

    @FindBy (tagName = "input")
    public List<WebElement> formBoxesAndContinue;

    public void fillFormAndContinue(String firstName, String lastName, String zipCode){
        formBoxesAndContinue.get(0).sendKeys(firstName);
        formBoxesAndContinue.get(1).sendKeys(lastName);
        formBoxesAndContinue.get(2).sendKeys(zipCode);
        formBoxesAndContinue.get(3).click();

    }
}
