package com.qualityhouse.course.altae.keyworddriventesting.steps.library;


import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.BasePageObject;
import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.LoginPageObject;
import com.qualityhouse.course.altae.keyworddriventesting.support.User;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BaseUserSteps
{
    private static final Logger logger = Logger.getLogger( BaseUserSteps.class );
    private BasePageObject basePageObject;
    private LoginPageObject loginPageObject;

    @Step
    public void openSite( )
    {
        logger.info( "Inside openSite() method" );
        this.basePageObject.open( );
        logger.info( "Exiting openSite()" );
    }

    @Step
    public void clicksOnMenuItem( String menu )
    {
        basePageObject.clickOnMenuItem( menu );
    }

    @Step
    public void typesIn( String fieldName,
                         String text )
    {
        loginPageObject.enterTextIn( fieldName,
                                     text );
    }

    @Step( value = "User submits the login form" )
    public void logsIn( User user )
    {
        loginPageObject.loginWithUser( user );
    }

    @Step
    public void clicksOnButton( String button )
    {
        basePageObject.clickOnButton( button );
    }

    public void hasLoggedInSuccessfully( )
    {
        Assert.assertTrue( "User is not logged in",
                           this.basePageObject.isUserLoggedIn( ) );
    }

    public void hasLoggedInFailed( )
    {
        Assert.assertTrue( "User is not logged in",
                           this.loginPageObject.isOpen( ) );
    }

    public void shouldSeeElementWithName( String elementName )
    {
        Assert.assertTrue( "Element with name " + elementName + " is not displayed",
                           this.loginPageObject.elementIsDisplayed( By.name( elementName ) ) );
    }

    public void shouldSeeElementWithId( String elementId )
    {
        Assert.assertTrue( "Element with id " + elementId + " is not displayed",
                           this.loginPageObject.elementIsDisplayed( By.id( elementId ) ) );
    }

    public void shouldSeeElementWithHref( String elementHref )
    {
        String cssSelector = "[href*='link']".replace( "link",
                                                      elementHref );
        Assert.assertTrue( "Element with href " + elementHref + " is not displayed",
                           this.loginPageObject.elementIsDisplayed( By.cssSelector( cssSelector ) ) );
    }
}
