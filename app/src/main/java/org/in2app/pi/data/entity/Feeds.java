package org.in2app.pi.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jaychung on 3/24/16.
 */
public class Feeds {
    @SerializedName("data")
    List<FeedItem> feedList;

    @SerializedName("paging")
    Paging paging;
}
