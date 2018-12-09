package com.qualityhouse.course.altae;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloJavaTest
{
    private WebDriver driver;

    @Test
    public void testLoginPageDisplays( )
    {

        this.driver.get( "http://www.acme.qualityhouse.bg/build1/index.php?page=login" );

        String pageTitle = driver.findElement( By.cssSelector( "#main-big-col > h3" ) )
                                 .getText( );

        Assert.assertEquals( "Page is not Login!",
                             "Login",
                             pageTitle );

        System.out.println( "\nEnvironment is ready for test automation course!" );
    }

    @Before
    public void setUpPerTest( )
    {

        // Optional, if not specified, WebDriver will search your path for chromedriver.
        // System.seProperty("webdriver.chrome.driver", "path to chrome driver");

        this.driver = new ChromeDriver( );
    }

    @After
    public void cleanUpAfterTest( )
    {
        this.driver.close( );
    }
}
