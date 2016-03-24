package org.in2app.pi.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaychung on 3/23/16.
 */
public class FeedData {
    @SerializedName("id")
    String id;
    @SerializedName("message")
    String message;
    @SerializedName("created_time")
    String creationTime;
    @SerializedName("type")
    String type;

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getType() {
        return type;
    }
}
