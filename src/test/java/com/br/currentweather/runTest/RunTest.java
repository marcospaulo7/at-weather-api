package com.br.currentweather.runTest;

import com.br.currentweather.utils.Constants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true,
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                plugin = {"pretty", "json:reports/cucumber.json"},
                features = {"./src/test/resources/feature"} ,
                glue = "com.br.currentweather.steps",
                tags = "@smoketest")


public class RunTest extends Constants {


}
