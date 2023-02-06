package com.ict650.hazardlocator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    Button toMap, toNews, toAboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toMap = (Button) findViewById(R.id.toMap);
        toNews = (Button) findViewById(R.id.toNews);
        toAboutus = (Button) findViewById(R.id.toaboutus);

        toNews.setOnClickListener(this);
        toMap.setOnClickListener(this);
        toAboutus.setOnClickListener(this);


//start google sign in
        TextView tvname = (TextView) findViewById(R.id.tvname);
        TextView tvemail = (TextView) findViewById(R.id.tvemail);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("Email");
        tvname.setText(name);
        tvemail.setText(email);
        Button signout = findViewById(R.id.signout);
        signout.setOnClickListener(this);
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//end google sign in

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.signout:
                signOut();
                break;
            case R.id.toMap:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.toNews:
                Intent intent2 = new Intent();
                intent2.setClass(getApplicationContext(), News.class);
                startActivity(intent2);
                break;
            case R.id.toaboutus:
                Intent intent3 = new Intent();
                intent3.setClass(getApplicationContext(), aboutus.class);
                startActivity(intent3);
                break;
        }

    }




    private void signOut() {

        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity2.this, "Successfully Logged Out", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

}