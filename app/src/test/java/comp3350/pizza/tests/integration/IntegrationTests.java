package pizzaApp.pizza.tests.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pizzaApp.pizza.tests.integration.DataAccessHSQLDBTest;
import pizzaApp.pizza.tests.integration.BusinessPersistenceSeamTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BusinessPersistenceSeamTest.class,
        DataAccessHSQLDBTest.class
})

public class IntegrationTests {
}
