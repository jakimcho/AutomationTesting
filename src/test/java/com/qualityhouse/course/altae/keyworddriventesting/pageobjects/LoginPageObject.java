package com.qualityhouse.course.altae.keyworddriventesting.pageobjects;

import com.qualityhouse.course.altae.keyworddriventesting.support.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl( "/index.php?page=login" )
public class LoginPageObject
        extends BasePageObject
{
    @FindBy( name = "username" ) private WebElementFacade usernameFieldElement;
    @FindBy( name = "userpass" ) private WebElementFacade passwordFieldElement;
    @FindBy( name = "ses_login" ) private WebElementFacade loginButtonElement;

    public void loginWithUser( User user )
    {
        this.logger.info( "Inside loginWithUser() method" );
        this.logger.info( "Populating the login form" );
        this.usernameFieldElement.waitUntilEnabled( )
                                 .type( user.getUsername( ) );
        this.passwordFieldElement.waitUntilEnabled( )
                                 .type( user.getPassword( ) );
        this.logger.info( "Submitting login form" );
        this.loginButtonElement.click( );
        this.logger.info( "Exiting loginWithUser() method" );
    }

    public boolean isOpen( )
    {
        this.logger.info( "Inside isOpen() method" );
        boolean isPageOpen = usernameFieldElement.isDisplayed( ) && usernameFieldElement.isDisplayed( );
        this.logger.info( "Exiting isOpen() method with result: " + isPageOpen);
        return isPageOpen;
    }
}
