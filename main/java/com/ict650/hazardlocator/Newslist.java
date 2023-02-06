
package com.ict650.hazardlocator;

import android.widget.ListAdapter;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Newslist {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content_desc")
    @Expose
    private String contentDesc;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("reporter")
    @Expose
    private String reporter;

    /**
     * No args constructor for use in serialization
     *
     */
    public Newslist() {
        String title;
        String contentDesc;
        String date;
        String reporter;
    }

    /**
     *
     * @param date
     * @param reporter
     * @param title
     * @param contentDesc
     */
    public Newslist(String title, String contentDesc, String date, String reporter) {
        super();
        this.title = title;
        this.contentDesc = contentDesc;
        this.date = date;
        this.reporter = reporter;
    }



    public String getTitle() {return title;};

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

}