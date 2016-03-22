package org.in2app.pi;

import android.app.Application;
import android.content.Context;

/**
 *
 * Created by jaychung on 1/2/16.
 */
public class App extends Application {

    private final static String FACEBOOK_PUBLIC_TOKEN = "424019454456359|1bKu9Z_qb5Ppyw5ysZ1-MSeh-So";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
