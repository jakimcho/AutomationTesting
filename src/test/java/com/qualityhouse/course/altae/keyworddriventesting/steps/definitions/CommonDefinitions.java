package com.qualityhouse.course.altae.keyworddriventesting.steps.definitions;

import com.qualityhouse.course.altae.keyworddriventesting.steps.library.BaseUserSteps;
import com.qualityhouse.course.altae.keyworddriventesting.support.User;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class CommonDefinitions
{
    @Steps private BaseUserSteps someUser;

    @Given( "^\"([^\"]*)\" page is opened$" )
    public void navigateToPage( String page )
    throws
            Exception
    {
        someUser.openSite( );
        someUser.clicksOnMenuItem( page );
    }

    @When( "^a user logs in:$" )
    public void aUserLogsIn( @Transpose Map<String, String> userRawData )
    throws
            Throwable
    {
        String username = userRawData.get( "username" );
        String password = userRawData.get( "password" );
        User user = new User( username,
                              password );
        someUser.logsIn( user );
    }

    @Then( "^the user is successfully logged in$" )
    public void theUserIsSuccessfullyLoggedIn( )
    throws
            Throwable
    {
        someUser.hasLoggedInSuccessfully( );
    }

    @Then( "^the user is not logged in$" )
    public void theUserIsNotLoggedIn( )
    throws
            Throwable
    {
        someUser.hasLoggedInFailed( );
    }
}
