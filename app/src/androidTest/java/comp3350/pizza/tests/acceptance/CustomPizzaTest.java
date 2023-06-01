package pizzaApp.pizza.tests.acceptance;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.*;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import pizzaApp.pizza.presentation.MainActivity;
import pizzaApp.pizza.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CustomPizzaTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testPrice() {
        onView(withId(R.id.main_order)).perform(click());
        onView(withId(R.id.sizeNext)).perform(click());
        onView(withId(R.id.crustNext)).perform(click());
        onView(withId(R.id.sauceNext)).perform(click());
        onView(withId(R.id.cheddarCheck)).perform(click());
        onView(withId(R.id.cheeseNext)).perform(click());
        onView(withId(R.id.chickenCheck)).perform(click());
        onView(withId(R.id.meatNext)).perform(click());
        onView(withId(R.id.tomatoCheck)).perform(click());
        onView(withId(R.id.redOnionCheck)).perform(click());
        onView(withId(R.id.veggiesNext)).perform(scrollTo(),click());
        onView(withId(R.id.orderTotal)).check(matches(withText("Total: $24.86")));
    }

    @Test
    public void testItemNames() {
        onView(withId(R.id.main_order)).perform(click());
        onView(withId(R.id.sizeNext)).perform(click());
        onView(withId(R.id.crustNext)).perform(click());
        onView(withId(R.id.sauceNext)).perform(click());
        onView(withId(R.id.cheddarCheck)).perform(click());
        onView(withId(R.id.mozzarellaCheck)).perform(click());
        onView(withId(R.id.cheeseNext)).perform(click());
        onView(withId(R.id.chickenCheck)).perform(click());
        onView(withId(R.id.meatNext)).perform(click());
        onView(withId(R.id.tomatoCheck)).perform(click());
        onView(withId(R.id.redOnionCheck)).perform(click());
        onView(withId(R.id.greenPepperCheck)).perform(click());
        onView(withId(R.id.veggiesNext)).perform(scrollTo(),click());
        onView(withId(R.id.orderDisplay)).check(matches(withText("Medium Pizza- White, Classic Red Sauce, Mozzarella, Cheddar, Chicken, Tomatoes, Green Pepper, Red Onions.")));
    }

    @Test
    public void testCancelOrder() {
        onView(withId(R.id.main_order)).perform(click());
        onView(withId(R.id.sizeNext)).perform(click());
        onView(withId(R.id.crustNext)).perform(click());
        onView(withId(R.id.sauceNext)).perform(click());
        onView(withId(R.id.cheddarCheck)).perform(click());
        onView(withId(R.id.mozzarellaCheck)).perform(click());
        onView(withId(R.id.cheeseNext)).perform(click());
        onView(withId(R.id.chickenCheck)).perform(click());
        onView(withId(R.id.meatNext)).perform(click());
        onView(withId(R.id.tomatoCheck)).perform(click());
        onView(withId(R.id.redOnionCheck)).perform(click());
        onView(withId(R.id.greenPepperCheck)).perform(click());
        onView(withId(R.id.veggiesNext)).perform(scrollTo(),click());
        onView(withId(R.id.orderTotal)).check(matches(withText("Total: $27.12")));
        onView(withId(R.id.orderDisplay)).check(matches(withText("Medium Pizza- White, Classic Red Sauce, Mozzarella, Cheddar, Chicken, Tomatoes, Green Pepper, Red Onions.")));
        onView(withId(R.id.cancelOrder)).perform(click());

        onView(withId(R.id.main_order)).perform(click());
        onView(withId(R.id.sizeNext)).perform(click());
        onView(withId(R.id.crustNext)).perform(click());
        onView(withId(R.id.sauceNext)).perform(click());
        onView(withId(R.id.cheddarCheck)).perform(click());
        onView(withId(R.id.cheeseNext)).perform(click());
        onView(withId(R.id.chickenCheck)).perform(click());
        onView(withId(R.id.meatNext)).perform(click());
        onView(withId(R.id.tomatoCheck)).perform(click());
        onView(withId(R.id.redOnionCheck)).perform(click());
        onView(withId(R.id.veggiesNext)).perform(scrollTo(),click());
        onView(withId(R.id.orderTotal)).check(matches(withText("Total: $24.86")));
        onView(withId(R.id.orderDisplay)).check(matches(withText("Medium Pizza- White, Classic Red Sauce, Cheddar, Chicken, Tomatoes, Red Onions.")));
    }
}//CustomPizzaTest
