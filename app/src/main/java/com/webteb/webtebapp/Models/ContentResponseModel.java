package com.webteb.webtebapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by khalid on 1/19/18.
 */

public class ContentResponseModel {

    @SerializedName("Name")
    String name;

    @SerializedName("Author")
    AuthorModel author;

    @SerializedName("Url")
    String url;

    @SerializedName("Fields")
    List<FieldModel> fields;

    @SerializedName("ImageUrl")
    String imageUrl;

    @SerializedName("Publishdate")
    String publishDate;

    @SerializedName("RelatedItems")
    List<RelatedItemModel> relatedItems;

    public String getName() {
        return name;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public List<FieldModel> getFields() {
        return fields;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public List<RelatedItemModel> getRelatedItems() {
        return relatedItems;
    }
}
