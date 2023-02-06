package com.ict650.hazardlocator;
//gson list
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class hazardslist {

    @SerializedName("location_name")
    @Expose
    public String locationName;
    @SerializedName("hazard_type")
    @Expose
    public String hazardType;
    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("reporter_name")
    @Expose
    public String reporterName;

}

