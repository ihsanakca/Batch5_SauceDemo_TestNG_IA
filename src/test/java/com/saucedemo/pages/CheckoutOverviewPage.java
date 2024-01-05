package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(css = ".summary_subtotal_label")
    public WebElement totalPrice;

    @FindBy(id = "finish")
    public WebElement finishLink;

    public void assertPrice(String expectedPrice){
        String actualPrice = totalPrice.getText();
        Assert.assertTrue(actualPrice.contains(expectedPrice));
    }

    public void navigateToFinish(){
        BrowserUtils.clickWithJS(finishLink);
    }


}
