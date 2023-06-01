package pizzaApp.pizza.tests.objects;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pizzaApp.pizza.tests.objects.PizzaPlanTest;
import pizzaApp.pizza.tests.objects.PizzaItemTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        PizzaItemTest.class,
        PizzaPlanTest.class
})

public class ObjectsTests {
}