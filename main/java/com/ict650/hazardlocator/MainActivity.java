package com.ict650.hazardlocator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    SignInButton signInButton;
    Task<Object> completedTask;


    private FusedLocationProviderClient fusedLocationClient;

    String[] perms = {"android.permission.ACCESS_FINE_LOCATION," +
            " android.permission.ACCESS_COARSE_LOCATION," +
            " android.permission.INTERNET," +
            " android.permission.ACCESS_NETWORK_STATE"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //----------------------------------------------------------------//
        // Set the dimensions of the sign-in button.
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(this);



        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account == null){
            //user x sign in lagi

            Toast.makeText(this, "Please sign in first", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("name",account.getDisplayName());
            intent.putExtra("Email",account.getEmail());

            startActivity(intent);
        }

//
        //----------------------------------------------------------------//

        ActivityCompat.requestPermissions(this, perms, 200);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 10);
                break;
        }
    }

    private void startActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 200) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }
    GoogleSignInAccount account;

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {

            account = (GoogleSignInAccount) completedTask.getResult(ApiException.class);

            Intent intent3 = new Intent(getApplicationContext(), MainActivity2.class);
            intent3.putExtra("name",account.getDisplayName());
            intent3.putExtra("Email",account.getEmail());

            startActivity(intent3);


            // Signed in successfully, show authenticated UI.
            //buka activity baru
            //updateUI(account);
        } catch (ApiException e) { //takboleh sign in
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("alamakkk", "signInResult:failed code=" + e.getStatusCode());

            Toast.makeText(this, "cannot sign in", Toast.LENGTH_SHORT).show();
            //updateUI(null);
        }
    }
}