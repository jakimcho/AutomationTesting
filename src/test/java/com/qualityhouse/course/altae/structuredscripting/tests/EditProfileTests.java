package com.qualityhouse.course.altae.structuredscripting.tests;

import com.qualityhouse.course.altae.structuredscripting.lib.CommonLib;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class EditProfileTests
{

    private WebDriver driver;

    @Before
    public void startUp() {
        driver = CommonLib.openBrowser( );

        CommonLib.navigateToApp(driver);
    }

    @After
    public void tearDown() {
        CommonLib.closeBrowser(driver);
    }

    @Test
    public void editUser1Profile() {
        // todo: Exercise no. 3.b - modify profile details of Student1

    }
}
