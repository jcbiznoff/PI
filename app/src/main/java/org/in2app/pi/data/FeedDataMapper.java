package org.in2app.pi.data;

import org.in2app.pi.data.entity.FeedData;
import org.in2app.pi.ui.model.FeedUIData;

/**
 * Created by jaychung on 3/23/16.
 */
public class FeedDataMapper {

    public FeedUIData transform (FeedData feedData){
        FeedUIData feedUIData = new FeedUIData();
        feedUIData.setId(feedData.getId());
        feedUIData.setMessage(feedData.getMessage());
        feedUIData.setCreationTime(feedData.getCreationTime());
        feedUIData.setType(feedData.getType());
        feedUIData.setCategory(parseCategoryData(feedData.getMessage()));
        feedUIData.setBodyMessage(parseBodyMessageData(feedData.getMessage()));
        return feedUIData;
    }

    private String parseBodyMessageData(String message) {
        return message.split("\\]")[1];
    }

    private String parseCategoryData(String message) {
        String category = message.split("\\]")[0];
        return category.substring(1); //exlude [
    }
}
