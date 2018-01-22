package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;
import com.webteb.webtebapp.Enums.ContentType;

/**
 * Created by khalid on 1/19/18.
 */

public class RelatedItemModel {

    @SerializedName("Description")
    String description;

    @SerializedName("Author")
    String author;

    @SerializedName("Url")
    String url;

    @SerializedName("ImageUrl")
    String imageUrl;

    @SerializedName("Title")
    String title;

    @SerializedName("ContentType")
    ContentType contentType;

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public ContentType getContentType() {
        return contentType;
    }
}
