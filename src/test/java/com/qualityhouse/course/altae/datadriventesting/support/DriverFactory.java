package com.qualityhouse.course.altae.datadriventesting.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{
    public static WebDriver getDriver( String browser )
    {
        WebDriver driver = null;
        switch( browser )
        {
            case "Chrome":
                driver = new ChromeDriver( );
                break;
            case "Firefox":
                driver = new FirefoxDriver( );
                break;
            default:
                driver = new ChromeDriver( );

        }

        return driver;
    }
}
