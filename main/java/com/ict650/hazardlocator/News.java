package com.ict650.hazardlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class News extends AppCompatActivity {

    ListView lv ;
    private String URL = "http://10.0.2.2/webWarning/public/";
    NewsApi myApi;
    private ArrayList<Newslist>modelArrayList;

    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_news);
        lv=findViewById ( R.id.listview );
        modelArrayList =new ArrayList<> ();

        displayRetrofitData();
    }

    private void displayRetrofitData() {
        Retrofit retrofit=new Retrofit.Builder ()
                .baseUrl ( URL )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        myApi = retrofit.create(NewsApi.class);
        Call<ArrayList<Newslist>> arrayListCall=myApi.callNews ();
        arrayListCall.enqueue ( new Callback<ArrayList<Newslist>>() {

            @Override
            public void onResponse(Call<ArrayList<Newslist>> call, Response<ArrayList<Newslist>> response) {
                modelArrayList = response.body ();
                for (int i=0;i<modelArrayList.size ();i++);
                //create adapter
                Custom custom = new Custom(modelArrayList,News.this,R.layout.singleview);
                lv.setAdapter ( custom );
            }

            @Override
            public void onFailure(Call<ArrayList<Newslist>> call, Throwable t) {
                Toast.makeText ( News.this, "Failed to load data", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }
}