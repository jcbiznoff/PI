package org.in2app.pi;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jaychung on 1/16/16.
 */
public class Navigator {

    public static void moveToFragment(AppCompatActivity activity, Fragment frag) {
        activity.getSupportFragmentManager().beginTransaction()
                .add(R.id.container_main, frag, frag.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }
}
