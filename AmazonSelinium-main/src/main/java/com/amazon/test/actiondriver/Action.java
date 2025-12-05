package com.amazon.test.actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Action {

    public static Logger log = LoggerFactory.getLogger(Action.class);

    public static void click(WebDriver driver, WebElement element){
        log.debug("when clicked on the element: {}", element);
        onClickElement(driver,element,11);
        element.click();
        log.info("click on the element: {}",element);
    }

    // to enter some text into the empty fields
    public static void typing(WebElement element,String text){
        log.debug("typing '{}' content into element: {}",text,element);
        element.clear();
        element.sendKeys(text);
        log.info("sent keys '{}',element",text);
    }

    // to check whether element is diplayed or not
    public  static  boolean isDisplayed(WebDriver webDriver, WebElement element){

        boolean display = false;
        try{
            display = element.isDisplayed();
            log.debug("element displayed:{}",display);
        }catch (Exception e){
            log.error("element is not displayed",e);
        }
        return display;
    }

    // it is ragarding the implicit wait
    public static void implicitWait(WebDriver driver, int time){
        log.info(" set the implicit wait to  {} seconds",time);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    //  time taken to page load
    public static void pageLoad(WebDriver driver,int time){
        log.info("it waits the page upto {} seconds",time);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }

    // after click on the elenment
    public static void onClickElement(WebDriver driver, WebElement element, int time){

        log.debug("wait upto {} seconds  certain time: {}",time,element);
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
        log.info("element is now clickable: {}",element);
    }

    // waiting ofr some time o fvisibility of element
    public static void waitForVisible(WebDriver driver, WebElement element, int time){
        log.debug("waiting upto {} seconds for the visibility: {}",time,element);
        new WebDriverWait(driver,Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf((element)));
        log.debug("element is visible: {}",element);
    }

    //
    public static void selectDropDown(WebElement element,String visibleText){
        log.debug("selecting '{}' from dropdown: {}",visibleText,element);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
        log.info("selected '{}' form dropdown: {}", visibleText,element);
    }


}

