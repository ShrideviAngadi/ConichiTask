package com.conichi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.*;
import javax.annotation.Nonnull;
import javax.annotation.Nonnegative;
import java.sql.Array;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class HomePageTests {
    public static final String XPATH_HOMEPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class,'txt')]/h1";
    public static final String XPATH_HAMBURGERMENU="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class,'nav_toggle')]";
    public static final String XPATH_FORHOTELS="//li[contains(@id, 'menu-item-25')]/a";
    public static final String XPATH_HOTELPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class,'txt')]/div";
    public static final String XPATH_CORPORATES="//li[contains(@id, 'menu-item-23')]/a";
    public static final String XPATH_CORPORATESPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class, 'txt')]/div";

    public static final String XPATH_RADIOBUTTONFIRST="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class,'pagination_list')]/a[1]";
    public static final String XPATH_FIRSTPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class, 'txt')]/div[1]";

    public static final String XPATH_RADIOBUTTONSECOND="//div[contains(@id, 'sections_wrapper')]/div[1]//div[contains(@class,'pagination_list')]/a[2]";
    public static final String XPATH_SECONDPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[2]//div[contains(@class, 'txt')]/h1";

    public static final String XPATH_RADIOBUTTONTHIRD="//div[contains(@id, 'sections_wrapper')]/div[2]//div[contains(@class,'pagination_list')][1]/a[3]";
    public static final String XPATH_THIRDPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[3]//div[contains(@class, 'txt')]/h1";

    public static final String XPATH_RADIOBUTTONFOURTH="//div[contains(@id, 'sections_wrapper')]/div[3]//div[contains(@class,'pagination_list')]/a[4]";
    public static final String XPATH_FOURTHPAGETEXT="//div[contains(@id, 'sections_wrapper')]/div[4]//div[contains(@class, 'txt')]/h1";

    public static final String XPATH_RADIOBUTTONFIVTH="//div[contains(@id, 'sections_wrapper')]/div[4]//div[contains(@class,'pagination_list')]/a[5]";
    public static final String XPATH_FIVTHPAGETEXT="//div[contains(@id, 'guest_hotels')]/h1";

    public static final String XPATH_FIRSTIMAGE="//div[contains(@id, 'media_links')]/a[1]";
    public static final String XPATH_SECONDIMAGE="//div[contains(@id, 'media_links')]/a[2]";
    private static final int WAIT_AFTER_MOUSE_OVER = 1000;
    WebDriver driver = null;

    @Test
    public void testConichiPageLoad() {

        setUpChrome();

        waitSeconds(2);

        // clicking on Hamburger Menu->For Hotels
        mouseOver(By.xpath(XPATH_HAMBURGERMENU));
        waitSeconds(1);
        mouseOver(By.xpath(XPATH_FORHOTELS));
        waitSeconds(1);
        driver.findElement(By.xpath(XPATH_FORHOTELS)).click();
        waitSeconds(2);


        if(driver.findElement(By.xpath(XPATH_HOTELPAGETEXT)).getText().contains("Imagine... guests check in mobile,")){
            System.out.println("Page contains same text");
        }else{
            System.out.println("Wrong text");
        }

        // clicking on Hamburger Menu->Corporates

        mouseOver(By.xpath(XPATH_HAMBURGERMENU));
        waitSeconds(1);
        mouseOver(By.xpath(XPATH_CORPORATES));
        waitSeconds(1);
        driver.findElement(By.xpath(XPATH_CORPORATES)).click();
        waitSeconds(2);

        if(driver.findElement(By.xpath(XPATH_CORPORATESPAGETEXT)).getText().contains("conichi provides travelers the most innovative")){
            System.out.println("Page contains same text");
        }else{
            System.out.println("Wrong text");
        }


        driver.quit();


    }

    @Test
    public void testConichiPageInteraction() {

        setUpChrome();

        //First Radio Button click
        driver.findElement(By.xpath(XPATH_RADIOBUTTONFIRST)).click();
        waitSeconds(1);
        if(driver.findElement(By.xpath(XPATH_FIRSTPAGETEXT)).getText().contains("Express Check-in")){
            System.out.println("Page contains same text");
        }else{
            System.out.println("Wrong text");
        }

        waitSeconds(1);
        //Second Radio Button click
        driver.findElement(By.xpath(XPATH_RADIOBUTTONSECOND)).click();
        waitSeconds(1);
        if(driver.findElement(By.xpath(XPATH_SECONDPAGETEXT)).getText().contains("Express Check-in")){
            System.out.println("Page contains same text");
        }else{
            System.out.println("Wrong text");
        }
        waitSeconds(1);

        //Third Radio Button click
        driver.findElement(By.xpath(XPATH_RADIOBUTTONTHIRD)).click();
        waitSeconds(1);
        if(driver.findElement(By.xpath(XPATH_THIRDPAGETEXT)).getText().contains("Keyless Access")){
            System.out.println("Page contains same text");
        } else {
            System.out.println("Wrong text");
        }

        waitSeconds(1);
        //Fourth Radio Button click
        driver.findElement(By.xpath(XPATH_RADIOBUTTONFOURTH)).click();
        waitSeconds(1);
        if(driver.findElement(By.xpath(XPATH_FOURTHPAGETEXT)).getText().contains("Mobile Check-out")){
            System.out.println("Page contains same text");
        } else {
            System.out.println("Wrong text");
        }

        waitSeconds(1);

        //Fifth Radio Button click
        driver.findElement(By.xpath(XPATH_RADIOBUTTONFIVTH)).click();
        waitSeconds(1);
        if(driver.findElement(By.xpath(XPATH_FIVTHPAGETEXT)).getText().contains("400+ SMARTHOTELS")){
            System.out.println("Page contains same text");
        }else{
            System.out.println("Wrong text");
        }

        waitSeconds(1);

        //Clicking on Icons in fivth page
        driver.findElement(By.xpath(XPATH_FIRSTIMAGE)).click();
        waitSeconds(3);

        // get all open tabs
        Object[] browserTabs = driver.getWindowHandles().toArray();

        // switch to tab 2
        driver.switchTo().window((String) browserTabs[1]);

        waitSeconds(2);

        waitSeconds(1);
        WebElement message=driver.findElement(By.xpath("//*[@id=\"TOP\"]/div[5]/article/div[1]/div[2]/div/header/div[1]/h2/span[2]"));
        String message1=message.getText();
        Assert.assertEquals("Einchecken ohne Hotelrezeption",message1);

        driver.quit();

    }

    protected void waitMillis(@Nonnegative int millis) {
        try {
            Thread.sleep(millis);

        } catch (InterruptedException ignored) {
        }

    }

    protected void waitSeconds(int seconds) {
        waitMillis(seconds * 1000);
    }

    protected void mouseOver(@Nonnull By by) {

        Actions mouseOverAction = new Actions( driver);
        mouseOverAction.moveToElement(driver.findElement(by)).perform();
        waitMillis(WAIT_AFTER_MOUSE_OVER);

    }

    protected void select(@Nonnull By by, @Nonnull String text) {
        mouseOver(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    protected void setUpChrome() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);
        driver.get("https://www.conichi.com/en/");
        waitSeconds(2);

        WebElement HomePageText = driver.findElement(By.xpath(XPATH_HOMEPAGETEXT));
        String HomePagemessage = HomePageText.getText();
        Assert.assertEquals("Seamless hotel stays", HomePagemessage);

    }

}
