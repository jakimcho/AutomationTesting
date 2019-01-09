package com.qualityhouse.course.altae.datadriventesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePageObject
{

    private WebDriver driver;
    private CommonPageObjects common;
    public String editProfilePage = "?page=edit-profile";

    public EditProfilePageObject( WebDriver driver )
    {
        this.driver = driver;
        common = new CommonPageObjects(driver);
    }

    /* list of page components */
    // todo: Exercise no. 2.a - list necessary  page components

    public By txtEmail = By.name( "cEmail" );

    public By txtName = By.name( "cName" );

    public By txtPhone = By.name( "cPhone" );

    public By txtAddress = By.name( "cAddress" );

    public By btnSubmit = By.cssSelector( "input[value='Submit']" );

    public By messageLocator = By.cssSelector( "#main-big-col b" );


    /* list of page actions */
    // todo: Exercise no. 2.b - list necessary  page actions
    public EditProfilePageObject open() {
        driver.get( common.applicationURL + editProfilePage );
        return this;
    }

    public EditProfilePageObject populateEmail( String email )
    {
        WebElement emailElement = this.driver.findElement( this.txtEmail );
        emailElement.clear( );
        emailElement.sendKeys( email );
        return this;
    }

    public EditProfilePageObject populateName( String name )
    {
        WebElement nameElement = this.driver.findElement( this.txtName );
        nameElement.clear( );
        nameElement.sendKeys( name );
        return this;
    }

    public EditProfilePageObject populatePhone( String phone )
    {
        WebElement phoneElement = this.driver.findElement( this.txtPhone );
        phoneElement.clear( );
        phoneElement.sendKeys( phone );
        return this;
    }

    public EditProfilePageObject populateAddress( String address )
    {
        WebElement addressElement = this.driver.findElement( this.txtAddress );
        addressElement.clear( );
        addressElement.sendKeys( address );
        return this;
    }

    public void submitProfileDetails( )
    {
        WebElement buttonElement = this.driver.findElement( this.btnSubmit );
        buttonElement.click( );
    }

    public String getSuccessfulMessage( ){
        WebElement messageElement = this.driver.findElement( messageLocator );
        return messageElement.getText();
    }
}
