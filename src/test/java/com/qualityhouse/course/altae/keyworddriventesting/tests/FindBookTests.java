package com.qualityhouse.course.altae.keyworddriventesting.tests;

import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.BooksPageObject;
import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.CommonPageObjects;
import com.qualityhouse.course.altae.keyworddriventesting.pageobjects.LoginPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBookTests
{

    private WebDriver driver = new ChromeDriver();

    private LoginPageObject loginPage = new LoginPageObject( driver);

    private CommonPageObjects common = new CommonPageObjects( driver);

    private BooksPageObject bookPage = new BooksPageObject( driver);


    @Before
    public void setup() { common.openApplication(); }

    @After
    public void tearDown() {
        common.closeApplication();
    }

    @Test
    public void tcVerifyIfBookIsInSearchResult() {
        loginPage.loginWithValidCredentials();

        bookPage.openBooks();

        // todo: implement this keyword
        bookPage.searchForBook("", "", "Nature Books Ltd.", "");

        Assert.assertEquals("Book is not in the list!", bookPage.isBookInList("Autumn Colors"), true);
    }

    @Test
    public void tcVerifyDetailsOfFoundBook() {
        // todo: Exercise no. 2 - search for a book with title "The miracles of the Nature" and list its details

    }

    @Test
    public void tcVerifyBookPrice() {
        // todo: Exercise no. 3 - develop keyword to easy verify given book price
    }
}
