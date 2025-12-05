package com.amazon.test.TestCases;

import com.amazon.test.Page.HomePage;
import com.amazon.test.Page.LoginPage;
import com.amazon.test.base.BaseClass;
import com.amazon.test.listener.ExtentTestListener;
import com.amazon.test.listener.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, ExtentTestListener.class})
public class LoginPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        Config();
        BrowserLaunch();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void setDown(){
        webDriver.quit();
    }

    @Test
    public void validLogin(){
        loginPage = homePage.clickOnSignIn();
        HomePage newpage = loginPage.login(properties.getProperty("username"), properties.getProperty("password") );
        Assert.assertTrue(newpage.getCurrUrl().contains("ref_=nav_ya_signin"),"login failed");

    }

    @Test
    public void invalidUsername(){
        loginPage = homePage.clickOnSignIn();
        loginPage.userName("abcd0888@gmail.com");
        Assert.assertTrue(loginPage.getUrl().contains("intent?arb"),"invalid username");
    }

    @Test
    public void invalidPassword(){
        loginPage = homePage.clickOnSignIn();
        loginPage.login(properties.getProperty("username"), "invalidPassword");
        Assert.assertTrue(loginPage.getUrl().contains("signin"),"invalid password");
    }

    @Test
    public void emptyCredentials(){
        loginPage = homePage.clickOnSignIn();
        loginPage.userName(" ");

        Assert.assertTrue(loginPage.getUrl().contains("signin"),"invalid password");
    }

    @Test
    public void userNameOnly() {
        loginPage = homePage.clickOnSignIn();
        loginPage.login(properties.getProperty("username"), "");
        Assert.assertTrue(loginPage.getUrl().contains("signin"), "Only username test failed");
    }
}

