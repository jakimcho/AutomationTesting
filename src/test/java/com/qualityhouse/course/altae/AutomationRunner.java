package com.qualityhouse.course.altae;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// The Control Script for our KEYWORD-DRIVEN tests
@RunWith( CucumberWithSerenity.class )
@CucumberOptions(
        plugin =
                {
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml"
                },
        features = "keyword_driven_features/",
        glue = "com.qualityhouse.course.altae.keyworddriventesting.steps.definitions",
        snippets = SnippetType.CAMELCASE,
        tags = { "@regression" } )

public class AutomationRunner
{

}
