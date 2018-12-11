package com.qualityhouse.course.altae.structuredscripting.tests;

import com.qualityhouse.course.altae.structuredscripting.lib.CommonLib;
import com.qualityhouse.course.altae.structuredscripting.lib.LoginLib;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTests
{
    private WebDriver driver;

    @Before
    public void startUp( )
    {
        driver = CommonLib.openBrowser( );
        CommonLib.navigateToApp( driver );
    }

    @After
    public void tearDown( )
    {
        CommonLib.closeBrowser( driver );
    }

    @Test
    public void successfulUserLogin( )
    {
        LoginLib.navigateToLoginPage( driver );

        LoginLib.loginAsUser( driver,
                              "student1",
                              "stpass1" );

        Assert.assertTrue( "The user login failed",
                          LoginLib.isUserLoggedIn( driver ) );
    }

    @Test
    public void successfulUserLogout( )
    {
        LoginLib.navigateToLoginPage( driver );

        LoginLib.loginAsUser( driver,
                              "student2",
                              "stpass2" );

        CommonLib.logoutFromApp( driver );

        Assert.assertTrue( "The user logout failed",
                           LoginLib.hasUserLoggedOut( driver ) );
    }

    @Test
    public void successfulUser3Logout( )
    {
        LoginLib.navigateToLoginPage( driver );

        LoginLib.loginAsUser( driver,
                              "student3",
                              "stpass3" );

        CommonLib.logoutFromApp( driver );

        Assert.assertTrue( "User3 logout failed",
                           LoginLib.hasUserLoggedOut( driver ) );
    }

    @Test
    public void activateLoginSecurity( )
    {
        // todo: Exercise no. 1 - login 3 times with username student1 by using wrong password; check for warning message

    }

    @Test
    public void allThreeUsersLogin( )
    {
        // todo: Exercise no. 2 - perform login (and logout) of three users (student1, student2, student3), sequentially

    }
}
