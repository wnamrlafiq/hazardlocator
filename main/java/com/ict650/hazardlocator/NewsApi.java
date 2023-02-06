package com.ict650.hazardlocator;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("news.json")
    Call<ArrayList<Newslist>> callNews();
}
