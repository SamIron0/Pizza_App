package pizzaApp.pizza.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pizzaApp.pizza.tests.integration.IntegrationTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        IntegrationTests.class
})

public class RunIntegrationTests {
}
