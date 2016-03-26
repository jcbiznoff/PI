package org.in2app.pi;

import android.app.Application;
import android.content.Context;

import com.firebase.client.Firebase;

import org.in2app.pi.data.net.RestClient;

/**
 *
 * Created by jaychung on 1/2/16.
 */
public class App extends Application {

    private RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
        restClient = getRestClient();
    }

    public static RestClient getRestClient() {
        return new RestClient();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


}
