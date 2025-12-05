package com.amazon.test.Page;
import com.amazon.test.actiondriver.Action;
import com.amazon.test.base.BaseClass;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Filter extends BaseClass {

    private  static  final Logger logger = LoggerFactory.getLogger(Filter.class);

    @FindBy(xpath = "//span[text()='Samsung']")
    WebElement SamsungBox;

    @FindBy(xpath = "//span[text()='Apple']")
    WebElement appleBox;

    @FindBy(xpath = "//input[@id='low-price']")
    WebElement minRange;

    @FindBy(xpath = "//input[@id='high-price']")
    WebElement maxRange;

    @FindBy(xpath = "//input[@aria-labelledby='a-autoid-1-announce']")
    WebElement goBut;

    @FindBy(xpath = "//a[@aria-label='Apply 4 Stars & Up filter to narrow results']")
    WebElement fourStars;

    @FindBy(xpath = "//span[text()='AMOLED']")
    WebElement amoledBox;

    @FindBy(xpath = "//span[text()='OLED']")
    WebElement oledBox;

    @FindBy(xpath = "//span[normalize-space()='256 GB']")
    WebElement mostStorage;

    @FindBy(xpath = "//span[normalize-space()='128 GB']")
    WebElement moreStorage;




    public  Filter() {
        PageFactory.initElements(webDriver,this);
        logger.info("filterPage intialized");

    }

    public void brandFilter(String brand){
        logger.info("applying a brand to be filter: {}",brand);
        if(brand.equalsIgnoreCase("samsung")) {
            Action.click(webDriver, SamsungBox);
            logger.info("samsung brand filter is applied");
        } else if(brand.equalsIgnoreCase("apple")){
            Action.click(webDriver, appleBox);
            logger.info("poco brand applied as a filter");
        }else{
            logger.warn("no filter is applied");
        }
    }

    public void displayFilter(String display){
        logger.info("applying a brand to be filter: {}",display);
        if(display.equalsIgnoreCase("amoled")) {
            Action.click(webDriver, amoledBox);
            logger.info("samsung brand filter is applied");
        } else if(display.equalsIgnoreCase("oled")){
            Action.click(webDriver, oledBox);
            logger.info("poco brand applied as a filter");
        }else{
            logger.warn("no filter is applied");
        }
    }

    public void storageFilter(String storage){
        logger.info("applying a brand to be filter: {}",storage);
        if(storage.equalsIgnoreCase("256")) {
            Action.click(webDriver, mostStorage);
            logger.info("samsung brand filter is applied");
        } else if(storage.equalsIgnoreCase("128")){
            Action.click(webDriver, moreStorage);
            logger.info("poco brand applied as a filter");
        }else{
            logger.warn("no filter is applied");
        }
    }


    public void priceFilter(String min, String max){

        minRange.clear();
        minRange.sendKeys(min);
        logger.info("sending the min value");

        maxRange.clear();
        maxRange.sendKeys(max);
        logger.info("applying the max range to the filter");

        Action.click(webDriver,goBut);
        logger.info("price filter applied");
    }



    public void applyRatingFilter() {
        logger.info("Applying 4 Stars & Up rating filter.");
        Action.click(webDriver, fourStars);
        logger.info("Rating filter applied.");
    }





}
