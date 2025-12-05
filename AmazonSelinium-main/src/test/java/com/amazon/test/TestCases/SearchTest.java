package com.amazon.test.TestCases;

import com.amazon.test.Page.HomePage;
import com.amazon.test.Page.Search;
import com.amazon.test.base.BaseClass;
import com.amazon.test.listener.ExtentTestListener;
import com.amazon.test.listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ObjectInputFilter;
@Listeners({TestListener.class, ExtentTestListener.class})
public class SearchTest extends BaseClass {

    HomePage homePage;
    Search search;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
        homePage = new HomePage();
    }

    @AfterMethod
    public void setDown(){
        webDriver.quit();
    }

    @Test
    public void validSearch(){
        homePage.searchBar("iphone");
        search = new Search();
        Assert.assertTrue(search.productDisplayed("iphone"));
    }

    @Test
    public void testInvalidProductSearch() {
        homePage.searchBar("adsdhbsfxyzInvalidProduct");
        search = new Search();
        Assert.assertFalse(search.productDisplayed("adsdhbsfxyzInvalidProduct"),
                "Invalid product unexpectedly found in Search Results");
    }



    @Test
    public void emptySearch(){
        homePage.searchBar(" ");
        search = new Search();
        Assert.assertFalse(search.productDisplayed(" "),"invalid product that you r looking for");
    }

    @Test
    public void electronicsSearch(){
        homePage.searchBar("mixer");
        search = new Search();
        Assert.assertTrue(search.productDisplayed("mixer"),"there is no valid product");
    }

    @Test
    public void goggleSearch(){
        homePage.searchBar("cooling goggles");
        search = new Search();
        Assert.assertTrue(search.productDisplayed("goggle"),"there is no valid product");
    }

    @Test
    public void instrumentSearch(){
        homePage.searchBar("violin");
        search = new Search();
        Assert.assertTrue(search.productDisplayed("violin"),"there is no valid product");
    }

    @Test
    public void cookiesSearch(){
        homePage.searchBar("cookies");
        search = new Search();
        Assert.assertTrue(search.productDisplayed("cookies"),"there is no valid product");
    }



}
