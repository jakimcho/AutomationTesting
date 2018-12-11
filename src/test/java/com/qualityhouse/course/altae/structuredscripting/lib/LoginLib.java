package com.qualityhouse.course.altae.structuredscripting.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginLib
{

    private final static Logger logger = LoggerFactory.getLogger( LoginLib.class );

    // open login page
    public static void navigateToLoginPage( WebDriver driver )
    {
        logger.info( "navigate to login page" );

        driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
              .click( );
    }

    // login in as given user, with provided username and password
    public static void loginAsUser( WebDriver driver,
                                    String username,
                                    String password )
    {
        logger.info( "log in as user - username = '{}', password = '{}'",
                     username,
                     password );

        driver.findElement( By.id( "username" ) )
              .sendKeys( username );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( password );

        driver.findElement( By.name( "ses_login" ) )
              .click( );
    }

    public static boolean isUserLoggedIn( WebDriver driver )
    {
        logger.info( "Checking if the user is logged in" );
        WebElement logoutButton = driver.findElement( By.cssSelector( "a[href='index.php?page=logout']" ) );
        WebElement editProfileButton = driver.findElement( By.cssSelector( "a[href='index.php?page=edit-profile']" ) );

        return logoutButton.isDisplayed( ) && editProfileButton.isDisplayed( );
    }

    public static boolean hasUserLoggedOut( WebDriver driver )
    {
        logger.info( "Checking if the user has logged out" );

        WebElement loginButton = driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) );

        return loginButton.isDisplayed();
    }
}
