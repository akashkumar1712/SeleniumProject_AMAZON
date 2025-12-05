package com.amazon.test.Page;

import com.amazon.test.actiondriver.Action;
import com.amazon.test.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BaseClass {

    public static final Logger log = LoggerFactory.getLogger(HomePage.class);

    @FindBy(id = "nav-logo-sprites")
    WebElement cartLogo;

    @FindBy(id = "twotabsearchtextbox")
    WebElement onSearchBar;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

//    @FindBy(id="nav-logobar-greeting")
//    @FindBy(id = "nav-link-accountList")
//    WebElement signInButton;   //older version hai yeah

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement signInButton;


    @FindBy(xpath = "//input[@data-action-type='DISMISS' and contains(@data-action-params, '\"toasterType\":\"AIS_INGRESS\"')]")
    WebElement DismissButton;

    @FindBy(id="nav-orders")
    WebElement sellpage;

    @FindBy(xpath = "//*[@id=\"icp-nav-flyout\"]/a/span")
    WebElement lang;






    public HomePage(){
        PageFactory.initElements(webDriver,this);
        log.debug("intializing the home elements");
    }

    public boolean validateLogo(){
        log.info("validate the cart logo");
        boolean isLogo = Action.isDisplayed(webDriver,cartLogo);
        log.info("logo is displayed {}",isLogo);
        return isLogo;
    }

    public void searchBar(String name){
        log.info("search the product : {}",name);
        Action.typing(onSearchBar,name);
        Action.click(webDriver,searchButton);
    }

    public Search searchButton(){
        log.debug("click on search product");
        Action.click(webDriver,searchButton);
        return new Search();
    }

    public String getCurrUrl(){
        String curUrl = webDriver.getCurrentUrl();
        log.debug("url of curr page: {}",curUrl);
        return curUrl;

    }

    public LoginPage clickOnSignIn(){
        log.info("click on sign in ");
        Action.click(webDriver,signInButton);
        log.info("navigate to the login page");
        return new LoginPage();
    }


    public void dismiss(){
        log.info("Dismissing popup if present");
        Action.click(webDriver,DismissButton);
    }

    public  void sellPage(){
        log.info("click on the sell ");
        Action.click(webDriver,sellpage);

    }

    public void lang(){
        log.info("click on the select country");
        Action.click(webDriver, lang);
    }



}
