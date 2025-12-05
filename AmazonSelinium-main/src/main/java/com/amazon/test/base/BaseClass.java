package com.amazon.test.base;

import com.amazon.test.actiondriver.Action;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BaseClass {

    public static Properties properties;
    public static WebDriver webDriver;

    private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);


    public void Config(){
        try{
            properties = new Properties();
            FileInputStream inp = new FileInputStream(System.getProperty("user.dir") + File.separator + "configuration" + File.separator + "config.properties");
            properties.load(inp);
            logger.info("properties loaded successfully");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void BrowserLaunch(){

        if(properties == null){
            throw new IllegalStateException("properties are not initialized properly");
        }

        String browser = properties.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            webDriver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("invalid browser" + browser);
        }

        Action.implicitWait(webDriver,10);
        Action.pageLoad(webDriver,10);
        webDriver.get(properties.getProperty("url"));
        logger.info("it launched on the browser : {}",browser);

    }



}
