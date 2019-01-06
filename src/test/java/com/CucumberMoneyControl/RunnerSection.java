package com.CucumberMoneyControl;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="feature_file.feature", glue={"com.step_definition"})
public class RunnerSection extends AbstractTestNGCucumberTests
{
	

}
