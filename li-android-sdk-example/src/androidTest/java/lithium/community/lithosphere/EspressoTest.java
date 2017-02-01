package lithium.community.lithosphere;

/**
 * Created by vikas.kumar on 12/19/16.
 */
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.SlidingDrawer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static java.lang.Thread.*;
import static org.hamcrest.CoreMatchers.allOf;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void postMessage() throws InterruptedException {

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Help & Support")).perform(click());
        onView(withText("Ask a question")).perform(click());
        onView(withId(R.id.li_ask_question_subject)).perform(typeText("Espresso Automation Test"), click());
        onView(withId(R.id.li_ask_question_body)).perform(typeText("Espresso Sample Test Message"), click());
        onView(withId(R.id.li_ask_question_select_category_label)).perform(click());
        onView(withText("AndroidSDK")).check(matches(isDisplayed())).perform(click());
        sleep(10000);
        onView(allOf( withText("CoreSdk Board"), isDisplayed())).perform(click());
        onView(withContentDescription("POST")).perform(click());


    }

}
