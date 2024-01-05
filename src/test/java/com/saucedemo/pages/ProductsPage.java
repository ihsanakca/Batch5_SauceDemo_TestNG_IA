package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    public static int shopCartCount=0;

    @FindBy(css = ".product_sort_container")
    public WebElement sortDropDown;

    @FindBy(className = "shopping_cart_link")
    public WebElement addToCartLink;

    public void selectDropDown(String sortType){
        Select select =new Select(sortDropDown);
        select.selectByVisibleText(sortType);
    }

    public void addItem(String productName){
        Driver.get().findElement(By.
                xpath("//div[text()='"+productName+"']/ancestor::*[@*='inventory_item_description']//button")).click();
        shopCartCount++;
    }

    public void navigateToCartPage(){
        addToCartLink.click();
    }
}
