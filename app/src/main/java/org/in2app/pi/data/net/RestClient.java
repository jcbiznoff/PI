package org.in2app.pi.data.net;

import retrofit.RestAdapter;

/**
 * Created by jaychung on 3/23/16.
 */
public class RestClient {
    private RestApi fbGraphService;

    String API_FEED_URL = "https://graph.facebook.com";

    public RestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(API_FEED_URL);

        fbGraphService = builder.build().create(RestApi.class);
    }

    public RestApi getFacebookGraphApi() {
        return fbGraphService;
    }
}
