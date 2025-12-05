package com.amazon.test.TestCases;

import com.amazon.test.Page.AddToCart;
import com.amazon.test.Page.HomePage;
import com.amazon.test.Page.LoginPage;
import com.amazon.test.Page.Search;
import com.amazon.test.base.BaseClass;
import com.amazon.test.listener.ExtentTestListener;
import com.amazon.test.listener.TestListener;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.logging.Logger;

@Listeners({TestListener.class, ExtentTestListener.class})
public class AddToCartTest  extends BaseClass {
    HomePage homePage;
    AddToCart addToCart;
    Search search;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
        homePage = new HomePage();
    }

    @AfterMethod
    public  void setDown(){
        webDriver.quit();
    }



    @Test
    public  void AddCartButton(){
        addToCart = new AddToCart();
        boolean isAdded = addToCart.AddToCartDisplayed();
        Assert.assertTrue(isAdded);
    }

    @Test
    public void goToCart(){
        addToCart = new AddToCart();
        addToCart.goToCart();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("nav_cart"),"err");
    }

    @Test
    public void testQuantity(){
        homePage.dismiss();
        LoginPage log1 = homePage.clickOnSignIn();
        log1.login(properties.getProperty("username"),properties.getProperty("password"));
        homePage.searchBar("iphone");
        search = new Search();

        addToCart = search.clickAddToCart();

        int count = 0;
        try{
            count = Integer.parseInt(addToCart.getItemCount());
        }catch (NumberFormatException e){
            count = 0;
        }

        addToCart.addQuantity();

        int finalCount = Integer.parseInt(addToCart.getItemCount());
        Assert.assertTrue(finalCount >= count+1);
    }
}
