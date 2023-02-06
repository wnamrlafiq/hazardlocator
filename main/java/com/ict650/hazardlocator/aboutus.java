package com.ict650.hazardlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class aboutus extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        setupHyperlink();

    }
    public void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.tvgithub);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setLinkTextColor(Color.BLUE);

        TextView link= findViewById(R.id.tvreport);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        link.setLinkTextColor(Color.BLUE);
    }
}