package pizzaApp.pizza.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pizzaApp.pizza.tests.business.BusinessTests;
import pizzaApp.pizza.tests.objects.ObjectsTests;
import pizzaApp.pizza.tests.persistence.PersistenceTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ObjectsTests.class,
        BusinessTests.class,
        PersistenceTests.class
})

public class RunUnitTests {

}
