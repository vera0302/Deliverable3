/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Yifan
 */
public class OnlineStoreTest extends BaseTest {

    //*****************************************************************************************
    /**
     * User story 1 
     * As a new customer, 
     * I want to view this site for more information. 
     * So that I can know what kind of products the online store have.
     */
    // Scenario 1: 
    // Given that I am on the online store site
    // When I view the title of the page
    // Then I see that it contains the word "ONLINE STORE"
    @Test
    public void testShowsCorrectTitle() {

        driver.get("http://store.demoqa.com/");

        // Simply check that the title contains the word "Toolsqa Dummy Test site"
        String title = driver.getTitle();
        assertTrue(title.contains("Toolsqa Dummy Test site"));
        driver.manage().deleteAllCookies();

    }

    // Scenario 2: 
    // Given that I am on the online store site
    // When I look at the top of the page
    // Then I should see a search textbox
    @Test
    public void testSearchBox() {

        driver.get("http://store.demoqa.com/");

        try {
            driver.findElement(By.className("search"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

//     Scenario 3: 
//     Given that I am on the online store site
//     When I click on the "All Product" menu link
//    // Then I should see a new directed page
    @Test
    public void testDirectedPage() {

        driver.get("http://store.demoqa.com/");

        // Find the "All Product" menu and click on it
        driver.findElement(By.linkText("All Product")).click();

        By productcategory = By.id("post-64");
        waitUntil(d -> d.findElement(productcategory).isDisplayed());

        try {
            assertEquals("Product Category | ONLINE STORE", driver.getTitle());
        } catch (NoSuchElementException nseex) {
            fail();
        }

        driver.manage().deleteAllCookies();
    }

    // Scenario 4: 
    // Given that I am going to buy the product 
    // When I click the "Buy Now" button
    // Then I should see a "Add To Cart" button
    @Test
    public void testBuy() {

        driver.get("http://store.demoqa.com/");

        // Find the "But Now" button and click on it
        driver.findElement(By.linkText("Buy Now")).click();

        By addcartbutton = By.className("input-button-buy");
        waitUntil(d -> d.findElement(addcartbutton).isDisplayed());

        try {
            driver.findElement(By.className("wpsc_buy_button"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    //*****************************************************************************************
    /**
     * User story 2 
     * As a new customer, 
     * I want to search products. 
     * So that I will find what I want to buy and then add to cart.
     */
    // Scenario 5: 
    // Given that I want to buy a mouse,
    // When I type the mouse in search box,
    // Then I should see a search result page.
    @Test
    public void testSearchProduct() {
        driver.get("http://store.demoqa.com/");

        // Find the search box and clear the text inside the textbox
        // Type "mouse" in the textbox
        driver.findElement(By.className("searchform")).findElement(By.className("search")).clear();
        driver.findElement(By.className("searchform")).findElement(By.className("search")).sendKeys("Magic" + Keys.RETURN);
//	driver.findElement(By.className("searchform")).click();

        // Wait until the search reasult comes out
        By searchresult = By.linkText("Magic Mouse");
        waitUntil(d -> d.findElement(searchresult).isDisplayed());

        try {
            assertEquals("Magic Mouse", driver.findElement(searchresult).getText());

        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    // Scenario 6: 
    // Given that the mouse search result page comes out,
    // When I click the "Add to Cart" button,
    // Then I should see the mouse in the cart.
    @Test
    public void testAddtoCart() {

        driver.get("http://store.demoqa.com/?s=Magic+Mouse&post_type=wpsc-product");

        // Click the "Add to Cart" button
        driver.findElement(By.className("wpsc_buy_button")).click();
        By msg = By.className("go_to_checkout");
        waitUntil(d -> d.findElement(msg).isDisplayed());

        // Click the "Go to Checkout" button
        driver.findElement(By.linkText("Go to Checkout")).click();

        // Wait until the checkout page comes out
        By checkout = By.id("post-29");
        waitUntil(d -> d.findElement(checkout).isDisplayed());

        try {
            driver.findElement(By.linkText("Magic Mouse"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

    //*****************************************************************************************
    /**
     * User story 3 
     * As a new customer, 
     * I want to create my own account. 
     * So that I can log in the site.
     */
    // Scenario 7: 
    // Given that I amd in the homepage and I want to create an account,
    // When I click on the "Account" icon
    // Then I should see the "Register" text
    @Test
    public void testRegisterText() {

        driver.get("http://store.demoqa.com/");
        
        // Find the "Account" icon and click on it
        driver.findElement(By.className("account_icon")).click();
        
        // Wait until the meta block shows up
        By register = By.id("meta");
        waitUntil(d -> d.findElement(register).isDisplayed());
        
        try {
            driver.findElement(By.linkText("Register"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }
    
    // Scenario 8: 
    // Given that I have already created an account
    // When I go to the login page and type my username and wrong password
    // Then I should see a login error message
    @Test
    public void testLoginFailure() {

        driver.get("http://store.demoqa.com/products-page/your-account/");
        
        // Enter the username and invalid password
        driver.findElement(By.id("log")).sendKeys("yiz105");
        driver.findElement(By.id("pwd")).sendKeys("yiz105");
        driver.findElement(By.id("login")).click();

        // Wait until the wrong error message shows up
        By errormsg = By.className("response");
        waitUntil(d -> d.findElement(errormsg).isDisplayed());

        try {
            assertEquals("ERROR: Invalid login credentials.", driver.findElement(errormsg).getText());
        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }
    
    // Scenario 9: 
    // Given that I have already created an account
    // When I go to the login page and type my username and password
    // Then I should see "(Logout)" text 
    @Test
    public void testLoginSuccess() {
        driver.get("http://store.demoqa.com/products-page/your-account/");
        
        // Enter correct username and password
        driver.findElement(By.id("log")).sendKeys("yiz105");
        driver.findElement(By.id("pwd")).sendKeys("yiz105@@");
        driver.findElement(By.id("login")).click();

        // Wait until login success
        By logouttext = By.id("account_logout");
        waitUntil(d -> d.findElement(logouttext).isDisplayed());

        try {
            assertEquals("(Logout)", driver.findElement(logouttext).getText());

        } catch (NoSuchElementException nseex) {
            fail();
        }
        driver.manage().deleteAllCookies();
    }

}
