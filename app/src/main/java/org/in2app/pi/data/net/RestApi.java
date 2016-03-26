package org.in2app.pi.data.net;

import org.in2app.pi.data.entity.FeedItem;
import org.in2app.pi.data.entity.Feeds;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by jaychung on 3/23/16.
 */
public interface RestApi {

    /**
     * Retrieves an {@link rx.Observable}.
     */
    @GET("/1384548091800506/feed")
    Observable<Feeds> getPublicFeed(
            @Query("access_token") String accessToken,
            @Query("fields") String fields
    );

}
