package com.qualityhouse.course.altae.linearscripting.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests
{

    @Test
    public void successfulUserLogin( )
    {
        WebDriver driver = new ChromeDriver( );

        driver.get( "http://acme.qualityhouse.bg/build3/index.php" );
        driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
              .click( );

        driver.findElement( By.id( "username" ) )
              .sendKeys( "student1" );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( "stpass1" );

        driver.findElement( By.name( "ses_login" ) )
              .click( );

        Assert.assertTrue( "The'logout' button is missing",
                           driver.findElement( By.cssSelector( "a[href='index.php?page=logout']" ) )
                                 .isDisplayed( ) );

        Assert.assertTrue( "The 'edit profile' button is missing",
                           driver.findElement( By.cssSelector( "a[href='index.php?page=edit-profile']" ) )
                                 .isDisplayed( ) );

        driver.close( );
    }

    @Test
    public void successfulUserLogout( )
    {
        WebDriver driver = new ChromeDriver( );

        driver.get( "http://acme.qualityhouse.bg/build3/index.php" );

        driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
              .click( );

        driver.findElement( By.id( "username" ) )
              .sendKeys( "student2" );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( "stpass2" );

        driver.findElement( By.name( "ses_login" ) )
              .click( );

        driver.findElement( By.cssSelector( "a[href='index.php?page=logout']" ) )
              .click( );

        driver.findElement( By.cssSelector( "a.big-btn[href='index.php?ses_logout=1']" ) )
              .click( );

        Assert.assertTrue( "User is not logged out.",
                           driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
                                 .isDisplayed( ) );
        driver.close( );
    }

    @Test
    public void tcLoginUser3( )
    {
        WebDriver driver = new ChromeDriver( );

        driver.get( "http://acme.qualityhouse.bg/build3/index.php" );

        driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
              .click( );

        driver.findElement( By.id( "username" ) )
              .sendKeys( "student3" );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( "stpass3" );

        driver.findElement( By.name( "ses_login" ) )
              .click( );

        driver.findElement( By.cssSelector( "a[href='index.php?page=logout']" ) )
              .click( );

        driver.findElement( By.cssSelector( "a.big-btn[href='index.php?ses_logout=1']" ) )
              .click( );

        Assert.assertEquals( "User is not logged out.",
                             true,
                             driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
                                   .isDisplayed( ) );

        driver.close( );
    }

    @Test
    public void tcTooManyUnsuccessfulLogins( )
    {
        WebDriver driver = new ChromeDriver( );

        driver.get( "http://acme.qualityhouse.bg/build3/index.php" );

        driver.findElement( By.cssSelector( "a[href='index.php?page=login']" ) )
              .click( );

        driver.findElement( By.id( "username" ) )
              .sendKeys( "student1" );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( "" );

        driver.findElement( By.name( "ses_login" ) )
              .click( );

        driver.findElement( By.id( "username" ) )
              .sendKeys( "student1" );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( "wrong" );

        driver.findElement( By.name( "ses_login" ) )
              .click( );

        driver.findElement( By.id( "username" ) )
              .sendKeys( "student1" );

        driver.findElement( By.name( "userpass" ) )
              .sendKeys( "wrong_again" );

        driver.findElement( By.name( "ses_login" ) )
              .click( );

        Assert.assertEquals( "Warning message is not displayed.",
                             true,
                             driver.findElement( By.cssSelector( "b.err" ) )
                                   .isDisplayed( ) );

        driver.close( );
    }

    @Test
    public void tcLoginWithSeveralUsers( )
    {
        // todo: Exercise no. 1 - perform login (and logout) of three users (student1, student2, student3), sequentially
    }

}
