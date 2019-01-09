package com.qualityhouse.course.altae.datadriventesting.tests;

import com.qualityhouse.course.altae.datadriventesting.data_providers.UserDataProviders;
import com.qualityhouse.course.altae.datadriventesting.pageobjects.CommonPageObjects;
import com.qualityhouse.course.altae.datadriventesting.pageobjects.EditProfilePageObject;
import com.qualityhouse.course.altae.datadriventesting.pageobjects.LoginPageObject;
import com.qualityhouse.course.altae.datadriventesting.support.DriverFactory;
import com.qualityhouse.course.altae.datadriventesting.support.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class EditProfileTests
{

    private WebDriver driver;
    private LoginPageObject loginPage;
    private CommonPageObjects common;
    private final static String SUCCESS_MESSAGE = "Your profile was updated successfully!";

    @Parameters( { "browser", "username", "password" } )
    @BeforeMethod
    public void setup( String browser,
                       String username,
                       String password )
    {
        this.driver = DriverFactory.getDriver( browser );
        this.common = new CommonPageObjects( driver );
        this.loginPage = new LoginPageObject( driver );
        this.loginPage.open( );
        this.loginPage.populateUsername( username );
        this.loginPage.populatePassword( password );
        this.loginPage.login( );
    }

    @AfterMethod
    public void tearDown( )
    {
        this.driver.quit( );
    }

    @Test( dataProvider = "validProfiles",
           dataProviderClass = UserDataProviders.class )
    public void tcEditProfileWithValidData( User userProfile )
    {
        EditProfilePageObject editProfilePageObject = new EditProfilePageObject( this.driver );
        editProfilePageObject.open( )
                             .populateName( userProfile.getName( ) )
                             .populateEmail( userProfile.getEmail( ) )
                             .populatePhone( userProfile.getPhone( ) )
                             .populateAddress( userProfile.getAddress( ) )
                             .submitProfileDetails( );

        Assert.assertEquals( SUCCESS_MESSAGE,
                             editProfilePageObject.getSuccessfulMessage( ),
                             "Wrong Successful message" );

    }

    @Test( dataProvider = "invalidProfiles",
           dataProviderClass = UserDataProviders.class )
    public void tcEditProfileWithInvalidData( User invalidProfile )
    {
        EditProfilePageObject editProfilePageObject = new EditProfilePageObject( this.driver );
        editProfilePageObject.open( )
                             .populateName( invalidProfile.getName( ) )
                             .populateEmail( invalidProfile.getEmail( ) )
                             .populatePhone( invalidProfile.getPhone( ) )
                             .populateAddress( invalidProfile.getAddress( ) )
                             .submitProfileDetails( );

        String errorMessage = driver.switchTo( )
                                    .alert( )
                                    .getText( )
                                    .trim( );
        Assert.assertEquals( "Please fill all required fields!",
                             errorMessage);
        // todo: Exercise no. 4.b - create "main test script" for the invalid modification of user's profile
        // hint: driver.switchTo().alert().dismiss()

    }
}
