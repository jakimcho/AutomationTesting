package com.qualityhouse.course.altae.keyworddriventesting.steps.definitions;

import com.qualityhouse.course.altae.keyworddriventesting.steps.library.BaseUserSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class KeywordDrivenSteps
{

    @Steps private BaseUserSteps someUser;

    @Given( "^a user has opened the site$" )
    public void openSite( )
    {
        someUser.openSite( );
    }

    @Given( "^the user has clicked on \"([^\"]*)\" menu$" )
    public void clickOnMenuItem( String menu )
    {
        someUser.clicksOnMenuItem( menu );
    }

    @When( "^user types in \"([^\"]*)\" field \"([^\"]*)\"$" )
    public void userTypesInField( String fieldName,
                                  String text )
    {
        someUser.typesIn( fieldName,
                          text );
    }

    @When( "^user clicks ok button \"([^\"]*)\"$" )
    public void userClicksOkButton( String button )
    {
        someUser.clicksOnButton( button );
    }

    @Then( "^the user should (?:still )?see (?:.*)? with name \"([^\"]*)\"$" )
    public void theUserShouldStillSeeElementWithName( String elementName )
    {
        someUser.shouldSeeElementWithName( elementName );
    }

    @Then( "^the user should (?:still )?see (?:.*)? with href \"([^\"]*)\"$" )
    public void theUserShouldStillSeeElementWithHref( String elementHref )
    {
        someUser.shouldSeeElementWithHref( elementHref );
    }


    @Then( "^the user should (?:still )?see (?:.*)? with id \"([^\"]*)\"$" )
    public void theUserShouldStillSeeElementWithId( String elementId )
    {
        someUser.shouldSeeElementWithId( elementId );
    }
}
