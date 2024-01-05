package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YourCartPage extends  BasePage{

    @FindBy(css = ".inventory_item_name")
    public List<WebElement> addedItemList;

    @FindBy(id = "checkout")
    public WebElement checkoutLink;

    public void navigateToCheckoutPage(){
        checkoutLink.click();
    }


}
