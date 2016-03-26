package org.in2app.pi.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaychung on 3/24/16.
 */
public class Paging {
    @SerializedName("previous")
    String previous;

    @SerializedName("next")
    String next;
}
