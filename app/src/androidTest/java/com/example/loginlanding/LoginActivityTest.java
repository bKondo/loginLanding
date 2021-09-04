package com.example.loginlanding;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest extends AppCompatActivity{
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.loginlanding", appContext.getPackageName());
    }

//    @Test
//    public void checkUsername_isCorrect() {
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//
//        Intent intent = new Intent(appContext,LoginActivity.class);
//        startActivity(intent);
//
//        assertTrue(checkUsername("Bret"));
//        assertFalse(checkUsername("cat"));
//    }
}
