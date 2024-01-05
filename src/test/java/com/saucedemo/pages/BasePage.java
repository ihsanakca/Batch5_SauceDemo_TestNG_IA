package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(className = "shopping_cart_badge")
    public WebElement shopCartCount;


    public String getPageName(String pageName){
        return Driver.get().findElement(By.xpath("//span[text()='"+pageName+"']")).getText();
    }

    public void assertPageName(String expectedPageName){
        Assert.assertEquals(getPageName(expectedPageName),expectedPageName);
    }

    public void assertCartCount(){
        String actual = shopCartCount.getText();
        String expected =String.valueOf(ProductsPage.shopCartCount);
        Assert.assertEquals(actual,expected);
    }
}
