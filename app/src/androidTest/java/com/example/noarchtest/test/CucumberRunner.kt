package com.example.noarchtest.test

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.noarchtest.stepdefinitions"],
    tags = ["@register"]
)

class CucumberRunner {
}
