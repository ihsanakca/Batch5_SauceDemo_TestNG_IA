package com.saucedemo.tests.sauceDemoE2ETest;

import com.saucedemo.pages.*;
import com.saucedemo.tests.TestBase;
import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SauceDemoTC_001 extends TestBase {

    @Test
    public void test1(){
        /**

         1-Create a TestNG  project from scratch. Design all packages, classes and ohter files... use last version of selenium
         2-Navigate to https://www.saucedemo.com/
         3-Login with valid credentials (shown on the page)
         4-Sort the products high to  low  (prepare a useful method for this )
         5-Add to cart at least two item
         6-Assert that the basket shows the true number of product
         7-Navigate to Your cart page
         8-Assert that the right items added to cart
         9-Go to checkout page and fill the form
         10-click continue button and go to the checkout overview page
         11-Click finish and assert the success shopping message

         notes:     a. every new page should be asserted by page title
         b. to have maximum step with minimum method  use the parameterized methods.
         c. This is an e2e test scenario

         good luck.

         */

        LoginPage loginPage=new LoginPage();
        ProductsPage productsPage=new ProductsPage();
        YourCartPage yourCartPage=new YourCartPage();
        CheckoutYourInformation checkoutYourInformation=new CheckoutYourInformation();
        CheckoutOverviewPage checkoutOverviewPage=new CheckoutOverviewPage();
        CheckoutCompletePage checkoutCompletePage=new CheckoutCompletePage();

        driver.get(ConfigurationReader.get("url"));

        loginPage.login();

        productsPage.assertPageName("Products");

        productsPage.selectDropDown("Price (high to low)");

        productsPage.addItem("Sauce Labs Bike Light");
        productsPage.addItem("Sauce Labs Bolt T-Shirt");
        productsPage.addItem("Sauce Labs Fleece Jacket");

        productsPage.assertCartCount();

        productsPage.navigateToCartPage();

        yourCartPage.assertPageName("Your Cart");


        List<String> actualList = BrowserUtils.getElementsText(yourCartPage.addedItemList);
      //  List<String> expectedList1 = new ArrayList<>(List.of("Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket"));
        List<String> expectedList = new ArrayList<>(Arrays.asList("Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket"));

        Assert.assertEquals(actualList,expectedList);

        yourCartPage.navigateToCheckoutPage();

        checkoutYourInformation.assertPageName("Checkout: Your Information");

        checkoutYourInformation.fillFormAndContinue("Ali","Aycan","34520");

        checkoutOverviewPage.assertPageName("Checkout: Overview");

        checkoutOverviewPage.assertPrice("75.97");

        checkoutOverviewPage.navigateToFinish();

        checkoutCompletePage.assertPageName("Checkout: Complete!");

        checkoutCompletePage.assertSuccessMessage("Thank you for your order!");

    }
}
