package com.qualityhouse.course.altae.keyworddriventesting.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl( "/index.php?page=edit-profile" )
public class EditProfilePageObject
        extends BasePageObject
{

    @FindBy( css = "#main-big-col b" ) private WebElementFacade messageElement;

    public String getMessage( )
    {
        logger.info( "Inside getMessage method" );
        String message = messageElement.waitUntilVisible( )
                                       .getText( )
                                       .trim( );
        logger.info( "Got message: " + message );
        return message;
    }
}
