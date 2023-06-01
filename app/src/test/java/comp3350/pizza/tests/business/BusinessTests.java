package pizzaApp.pizza.tests.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pizzaApp.pizza.tests.business.AccessTest;
import pizzaApp.pizza.tests.business.CalculateCostTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AccessTest.class,
        CalculateCostTest.class
})

public class BusinessTests {

}
