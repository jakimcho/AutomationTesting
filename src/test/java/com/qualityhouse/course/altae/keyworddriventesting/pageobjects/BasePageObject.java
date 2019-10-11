package com.qualityhouse.course.altae.keyworddriventesting.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

@DefaultUrl( "/" )
public class BasePageObject
        extends PageObject
{
    protected final Logger logger = Logger.getLogger( this.getClass( )
                                                          .getName( ) );

    @FindBy( linkText = "Home" ) private WebElementFacade homeMenuItemElement;
    @FindBy( linkText = "Books" ) private WebElementFacade booksMenuItemElement;
    @FindBy( linkText = "CDs" ) private WebElementFacade cdsMenuItemElement;
    @FindBy( linkText = "Basket" ) private WebElementFacade basketMenuItemElement;
    @FindBy( linkText = "Register" ) private WebElementFacade registerMenuItemElement;
    @FindBy( linkText = "Login" ) private WebElementFacade loginMenuItemElement;
    @FindBy( linkText = "Logout" ) private WebElementFacade logoutMenuItemElement;

    public void clickOnMenuItem( String menuItem )
    {
        logger.info( "Inside navigateToLoginPage() method" );
        logger.info( "Clicking on \"" + menuItem + "\" menu" );
        switch( menuItem )
        {
            case "Home":
                this.homeMenuItemElement.waitUntilClickable( )
                                        .click( );
                break;

            case "Books":
                this.booksMenuItemElement.waitUntilClickable( )
                                         .click( );
                break;

            case "CDs":
                this.cdsMenuItemElement.waitUntilClickable( )
                                       .click( );
                break;
            case "Basket":
                this.basketMenuItemElement.waitUntilClickable( )
                                          .click( );
                break;

            case "Register":
                this.registerMenuItemElement.waitUntilClickable( )
                                            .click( );
                break;

            case "Login":
                this.loginMenuItemElement.waitUntilClickable( )
                                         .click( );
                break;
        }

        logger.info( "Exiting navigateToLoginPage() method" );
    }

    public boolean isUserLoggedIn( )
    {
        logger.info( "Inside isUserLoggedIn() method" );
        boolean isLogoutMenuDisplayed = logoutMenuItemElement.isDisplayed( );
        logger.info( "Exiting isUserLoggedIn() method with res: " + isLogoutMenuDisplayed );
        return isLogoutMenuDisplayed;
    }

    public void enterTextIn( String fieldName,
                             String text )
    {
        logger.info( "Inside enterTextIn() method" );
        logger.info( "Locating input field with name: " + fieldName );
        WebElementFacade field = find( By.name( fieldName ) );
        logger.info( "Entering \"" + text + "\" text in " + fieldName + " \"field\"" );
        field.type( text );
        logger.info( "Exiting enterTextIn() method" );
    }

    public void clickOnButton( String button )
    {
        this.logger.info( "Inside clickOnButton() method" );
        WebElementFacade buttonElement;
        try
        {
            this.logger.info( "Locating button field with value: " + button );
            buttonElement = find( By.cssSelector( "*[value='" + button + "']" ) );
        } catch( NoSuchElementException e )
        {
            this.logger.info( "No button with value: " + button );
            this.logger.info( "Locating button field by text: " + button );
            buttonElement = find( By.xpath( "//button[text() ='" + button + "']" ) );
        }

        logger.info( "Clicking on button: " + button );
        buttonElement.waitUntilClickable( )
                     .click( );
        logger.info( "Exiting clickOnButton() method" );
    }

    public boolean elementIsDisplayed( By elementLocator )
    {
        this.logger.info( "Inside elementIsDisplayed() method" );
        boolean result = false;
        WebElementFacade element = null;
        try
        {
            this.logger.info( "Locating the element by " + elementLocator.toString() );
            element = find( elementLocator  );
            result = element.isDisplayed( );
        } catch( NoSuchElementException e )
        {
            this.logger.info( "Element with: " + elementLocator.toString() + " is not displayed on this page" );
        }

        this.logger.info( "Inside elementIsDisplayed() method with result " + result );
        return result;
    }
}
