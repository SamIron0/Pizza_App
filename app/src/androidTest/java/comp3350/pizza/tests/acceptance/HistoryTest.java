package pizzaApp.pizza.tests.acceptance;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.*;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.anything;
import pizzaApp.pizza.presentation.MainActivity;
import pizzaApp.pizza.R;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class HistoryTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testPreviousOrder() {
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
        onView((withId(R.id.placeOrder))).perform(click());
        onView((withId(R.id.Home))).perform(click());

        onView((withId(R.id.main_history))).perform(click());
        onView(first(withText("Custom Pizza History: Medium, White, Classic Red Sauce, Cheddar, Chicken, Tomatoes, Red Onions"))).perform(click());
        onView(withId(R.id.orderTotal)).check(matches(withText("Total: $24.86")));
        onView(withId(R.id.orderDisplay)).check(matches(withText("Medium Pizza- White, Classic Red Sauce, Cheddar, Chicken, Tomatoes, Red Onions.")));
        onView((withId(R.id.placeOrder))).perform(click());
    }

    //https://stackoverflow.com/a/36866682
    private <T> Matcher<T> first(final Matcher<T> matcher) {
        return new BaseMatcher<T>() {
            boolean isFirst = true;

            @Override
            public boolean matches(final Object item) {
                if (isFirst && matcher.matches(item)) {
                    isFirst = false;
                    return true;
                }
                return false;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("should return first matching item");
            }
        };
    }
}//HistoryTest


