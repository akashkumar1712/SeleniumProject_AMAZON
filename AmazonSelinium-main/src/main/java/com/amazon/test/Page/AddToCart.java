package com.amazon.test.Page;
import com.amazon.test.actiondriver.Action;
import com.amazon.test.base.BaseClass;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCart extends BaseClass {
    public static final Logger log = LoggerFactory.getLogger(AddToCart.class);

    @FindBy(xpath = "//a[@title='See All Buying Options' and contains(text(),'See All Buying Options')]")
    WebElement option;

    @FindBy(xpath = "//input[@name='submit.addToCart' and @type='submit' and contains(@aria-label, 'Add to Cart')]")
    WebElement addToCartButton;


    @FindBy(id = "nav-cart")
    WebElement cartIcon;

    @FindBy(xpath = "//span[contains(@id,'nav-cart-count')]")
    WebElement itemCount;



    public AddToCart(){
        PageFactory.initElements(webDriver,this);
        log.debug("add to cart page is initialized");
    }

    public void  addQuantity(){
        log.info("to add quantity of the product");
        Action.click(webDriver,option);
        log.debug("click on ");
        Action.click(webDriver, addToCartButton);
        log.info("clicked the add to cart button");

    }

    public boolean AddToCartDisplayed(){
        log.debug("checking if cart icon is dispalyed");
        boolean display = Action.isDisplayed(webDriver,cartIcon);
        log.info("cart icon is displayed : {}", display);
        return display;
    }

    public String getItemCount(){
        String count = itemCount.getText();
        log.info("retrieved the cart ietm count: {}",count);
        return count;
    }

    public void goToCart(){
        log.info("it will navigates to the cart");
        Action.click(webDriver,cartIcon);
    }

}

