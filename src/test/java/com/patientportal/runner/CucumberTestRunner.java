package com.patientportal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"},
        glue = "com/patientportal/stepdefs",
        tags = "@login")

public class CucumberTestRunner {
}
