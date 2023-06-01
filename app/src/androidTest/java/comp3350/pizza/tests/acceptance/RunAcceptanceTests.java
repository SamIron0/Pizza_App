package pizzaApp.pizza.tests.acceptance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        HistoryTest.class,
        CustomPizzaTest.class,
        SpecialPizzaTest.class
})

public class RunAcceptanceTests{

}