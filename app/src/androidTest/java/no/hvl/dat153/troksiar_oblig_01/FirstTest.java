package no.hvl.dat153.troksiar_oblig_01;


import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.ColumnInfo;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.annotation.UiThreadTest;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import no.hvl.dat153.troksiar_oblig_01.ImageAdapter;
import no.hvl.dat153.troksiar_oblig_01.R;
import no.hvl.dat153.troksiar_oblig_01.activities.QuizActivity;
import no.hvl.dat153.troksiar_oblig_01.data.Item;
import no.hvl.dat153.troksiar_oblig_01.data.ItemDao;
import no.hvl.dat153.troksiar_oblig_01.data.ItemDao_Impl;
import no.hvl.dat153.troksiar_oblig_01.data.ItemRepository;
import no.hvl.dat153.troksiar_oblig_01.data.ItemRoomDatabase;
import no.hvl.dat153.troksiar_oblig_01.data.ItemViewModel;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


//@LargeTest
@RunWith(AndroidJUnit4.class)
public class FirstTest{

    private ItemDao itemDao;
    private ItemRoomDatabase db;

    @Rule
    public ActivityTestRule<QuizActivity> mActivityTestRule = new ActivityTestRule<>(QuizActivity.class, false, false);//{
       //@Override
      // Activity a = mActivityTestRule.getActivity();
      // String p = a.get
      /* super.QuizActivity.
        protected Intent getActivityIntent() {
            Intent intent = new Intent();
            //intent.putExtra("myobj", myObj);
            return intent;
        }
    };*/



    @Before
    public void createDb() {
        List<Item> list = new ArrayList<>();
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, ItemRoomDatabase.class).build();
        itemDao = db.itemDao();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.character1);
        Item item = new Item("test1", bitmap);
        itemDao.addItem(item);
        list.add(item);

        if(list.size()==1){
            //mActivityTestRule.getActivity().setItems(list);
            Activity a = mActivityTestRule.getActivity();
            //a.setItems(list);
            mActivityTestRule.launchActivity(null);
        }

    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void firstTest() {
        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.quiz_photo_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("Julia"), closeSoftKeyboard());

        ViewInteraction appCompatEditText1 = onView(
                allOf(withId(R.id.quiz_photo_name), withText("Julia"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText1.perform(pressImeActionButton());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.button_check), withText("Check"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.score), withText("Score: 1 of 1"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("Score: 1 of 1")));
    }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}



