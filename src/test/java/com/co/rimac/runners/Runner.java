package com.co.rimac.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/carrito.feature",
        glue = "com.co.rimac.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Runner {
}
