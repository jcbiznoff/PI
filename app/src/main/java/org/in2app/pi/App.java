package org.in2app.pi;

import android.app.Application;
import android.content.Context;
import com.parse.Parse;

/**
 *
 * Created by jaychung on 1/2/16.
 */
public class App extends Application {

    private final static String PARSE_APP_KEY = "kcmNwFnHHDfanE4xbzZYzufPe5Cz74z1O4wftbej";
    private final static String PARSE_APP_SECRET = "VYQRtVcSJWUhGhjuLuy8kA7HKQ7rzbHa7Y37Work";

    @Override
    public void onCreate() {
        super.onCreate();
        setupParseSDK();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    private void setupParseSDK() {
        Parse.initialize(this, PARSE_APP_KEY, PARSE_APP_SECRET);
    }
}
