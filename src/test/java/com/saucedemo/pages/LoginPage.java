package com.saucedemo.pages;

import com.saucedemo.utilities.ConfigurationReader;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy (tagName = "input")
    private List<WebElement> loginInputs;

    public void login(){
        loginInputs.get(0).sendKeys(ConfigurationReader.get("username"));
        loginInputs.get(1).sendKeys(ConfigurationReader.get("password"));
        loginInputs.get(2).click();
    }
}
