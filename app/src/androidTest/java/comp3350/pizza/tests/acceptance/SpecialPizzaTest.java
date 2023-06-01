package pizzaApp.pizza.tests.acceptance;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import pizzaApp.pizza.presentation.MainActivity;
import pizzaApp.pizza.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SpecialPizzaTest {
    @Rule
        public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

        @Test
        public void testPrice() {
            onView(withId(R.id.main_specials)).perform(click());
            onView(withId(R.id.specialsNext)).perform(scrollTo(),click());
            onView(withId(R.id.orderTotal)).check(matches(withText("Total: $29.38")));
        }

        @Test
        public void testItemNames() {
            onView(withId(R.id.main_specials)).perform(click());
            onView(withId(R.id.specialsNext)).perform(scrollTo(),click());
            onView(withId(R.id.orderDisplay)).check(matches(withText("Medium Pizza- White, Classic Red Sauce, Cheddar, Ham, Italian Sausage, Chicken, Pepperoni.")));
        }
        @Test
        public void testChangeItems(){
            onView(withId(R.id.main_specials)).perform(click());
            onView(withId(R.id.specialsNext)).perform(scrollTo(),click());
            onView(withId(R.id.orderDisplay)).check(matches(withText("Medium Pizza- White, Classic Red Sauce, Cheddar, Ham, Italian Sausage, Chicken, Pepperoni.")));
            onView(withId(R.id.orderTotal)).check(matches(withText("Total: $29.38")));
            onView(withId(R.id.cancelOrder)).perform(click());

            onView(withId(R.id.main_specials)).perform(click());
            onView(withId(R.id.smallSpecial)).perform(click());
            onView(withId(R.id.veggieLovers)).perform(click());
            onView(withId(R.id.specialsNext)).perform(scrollTo(),click());
            onView(withId(R.id.orderDisplay)).check(matches(withText("Small Pizza- Whole Wheat, Classic Red Sauce, Cheddar, Mushrooms, Tomatoes, Red Onions, Jalapenos.")));
            onView(withId(R.id.orderTotal)).check(matches(withText("Total: $23.73")));
        }
}//SpecialPizzaTest

