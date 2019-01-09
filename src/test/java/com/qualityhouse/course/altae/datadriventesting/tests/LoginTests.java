package com.qualityhouse.course.altae.datadriventesting.tests;

import com.qualityhouse.course.altae.datadriventesting.data_providers.UserDataProviders;
import com.qualityhouse.course.altae.datadriventesting.pageobjects.CommonPageObjects;
import com.qualityhouse.course.altae.datadriventesting.pageobjects.LoginPageObject;
import com.qualityhouse.course.altae.datadriventesting.support.DriverFactory;
import com.qualityhouse.course.altae.datadriventesting.support.User;
import com.qualityhouse.course.altae.datadriventesting.support.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTests
{
    private WebDriver driver;
    private LoginPageObject loginPage;
    private CommonPageObjects common;

    @Parameters( "browser" )
    @BeforeMethod
    public void setup( String browser )
    {
        this.driver = DriverFactory.getDriver( browser );
        this.common = new CommonPageObjects( driver );
        this.loginPage = new LoginPageObject( driver );
        this.common.openApplication( );
    }

    @AfterMethod
    public void tearDown( )
    {
        this.driver.quit( );
    }

    @Ignore
    @Test( dataProvider = "validLogins",
           dataProviderClass = UserDataProviders.class )
    public void tcLoginWithValidCredentials( User user )
    {
        // so called "control script"
        loginPage.open( );
        loginPage.populateUsername( user.getUsername( ) );
        loginPage.populatePassword( user.getPassword( ) );
        loginPage.login( );
        boolean isUserLoggedIn = Utils.isPresent( driver,
                                                  common.menuLogout );
        Assert.assertTrue( isUserLoggedIn,
                           "User did not log in" );
        common.logout( );
    }

    @Ignore
    @Test( dataProvider = "invalidLogins",
           dataProviderClass = UserDataProviders.class )
    public void tcLoginWithInvalidCredentials( User user )
    {
        // so called "control script"
        loginPage.open( );
        loginPage.populateUsername( user.getUsername( ) );
        loginPage.populatePassword( user.getPassword( ) );
        loginPage.login( );
        boolean didLoginFail = Utils.isPresent( driver,
                                                common.menuLogin );
        Assert.assertTrue( didLoginFail,
                           "User did log in" );
    }

}
