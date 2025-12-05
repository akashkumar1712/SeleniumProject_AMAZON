package com.amazon.test.Page;

import com.amazon.test.actiondriver.Action;
import com.amazon.test.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id="ap_email_login")
    WebElement userName;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement password;

    @FindBy(id = "signInSubmit")
    WebElement LoginButton;





    // Constructor to initialize driver and elements
    public LoginPage() {
        PageFactory.initElements(webDriver, this);
        log.debug("login page elements are initialized");
    }

    public HomePage login(String uname,String pwd){
        log.info("log in with the username: {}",uname);
        Action.typing(userName, uname);
        Action.click(webDriver, continueButton);
        log.debug("enter the username and click on the continue");
        Action.typing(password,pwd);
        Action.click(webDriver, LoginButton);
        log.info("password entered and clickd the login");
        return new HomePage();
    }

    public void userName(String name){
        log.info("enter the username: {}",name);
        Action.typing(userName,name);
        Action.click(webDriver,continueButton);

    }

    public  String getUrl(){
        String loginUrl = webDriver.getCurrentUrl();
        log.debug("curr url on the login page: {}",loginUrl);
        return loginUrl;
    }



}
