package com.qualityhouse.course.altae.datadriventesting.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory
{
    public static WebDriver getDriver( String browser )
    {
        setDriversPaths();
        WebDriver driver = null;
        switch ( browser )
        {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();

        }

        return driver;
    }

    private static void setDriversPaths()
    {
        Map<String, String> driversPath = new HashMap<>();
        driversPath.put( "linux",
                         "drivers/linux/chromedriver" );
        driversPath.put( "mac",
                         "drivers/mac/chromedriver" );
        driversPath.put( "windows",
                         "drivers/windows/chromedriver.exe" );
        String tasOS = System.getProperty( "os.name" )
                             .toLowerCase()
                             .split( " " )[0];
        System.out.println( "Current OS is: " + tasOS );
        System.setProperty( "webdriver.chrome.driver",
                            driversPath.get( tasOS ) );
    }
}
