package com.qualityhouse.course.altae;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class HelloJavaTest
{
    private WebDriver driver;

    @Test
    public void testLoginPageDisplays( )
    {

        this.driver.get( "http://www.acme.qualityhouse.com/build1/index.php?page=login" );

        String pageTitle = driver.findElement( By.cssSelector( "#main-big-col > h3" ) )
                                 .getText( );

        Assert.assertEquals( "Page is not LoginTests!",
                             "LoginTests",
                             pageTitle );

        System.out.println( "\nEnvironment is ready for test automation course!" );
    }

    @Before
    public void setUpPerTest( )
    {

        // Optional, if not specified, WebDriver will search your path for chromedriver.
        // System.seProperty("webdriver.chrome.driver", "path to chrome driver");

        Map<String, String> driversPath = new HashMap<>( );
        driversPath.put( "linux",
                         "drivers/linux/chromedriver" );
        driversPath.put( "mac",
                         "drivers/mac/chromedriver" );
        driversPath.put( "windows",
                         "drivers/windows/chromedriver.exe" );
        String tasOS = System.getProperty( "os.name" )
                             .toLowerCase( )
                             .split( " " )[0];
        System.out.println( "Current OS is: " + tasOS );
        System.setProperty( "webdriver.chrome.driver",
                            driversPath.get( tasOS ) );
        this.driver = new ChromeDriver( );
    }

    @After
    public void cleanUpAfterTest( )
    {
        this.driver.close( );
    }
}
