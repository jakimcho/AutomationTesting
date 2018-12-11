package com.qualityhouse.course.altae.keyworddriventesting.tests;

import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.CommonPageObjects;
import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.EditProfilePageObject;
import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.LoginPageObject;
import com.qualityhouse.course.altae.keyworddriventesting.testdata.EditProfileTestData;
import com.qualityhouse.course.altae.keyworddriventesting.testdata.LoginTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditProfileTests
{

    private WebDriver driver = new ChromeDriver( );

    private LoginPageObject loginPage = new LoginPageObject( driver );

    private CommonPageObjects common = new CommonPageObjects( driver );

    private EditProfilePageObject editProfilePage = new EditProfilePageObject( driver );

    @Before
    public void setup( )
    {
        common.openApplication( );
    }

    @After
    public void tearDown( )
    {
        common.closeApplication( );
    }


    @Test
    public void tcModifyUserProfileDetailsDirect( )
    {
        loginPage.loginAs( "student3",
                           "stpass3" );

        editProfilePage.open( );

        editProfilePage.modifyProfileDetails( "student3@example.com",
                                              "Student Three",
                                              "+333333",
                                              "Student Street 3" );

        common.logout( );
    }


    @Test
    public void tcModifyUserProfileDetailsIndirect( )
    {
        loginPage.loginAs( LoginTestData.validUsers.get( 1 )
                                                   .getUsername( ),
                           LoginTestData.validUsers.get( 1 )
                                                   .getPassword( ) );

        editProfilePage.open( );

        editProfilePage.modifyProfileDetailsOf( EditProfileTestData.validUsers.get( 1 ) );

        common.logout( );
    }


    @Test
    public void tcModifyUserProfileDetailsWithValidDetails( )
    {
        loginPage.loginWithValidCredentials( );

        editProfilePage.open( );

        editProfilePage.modifyProfileWithValidDetails( );

        common.logout( );
    }

}
