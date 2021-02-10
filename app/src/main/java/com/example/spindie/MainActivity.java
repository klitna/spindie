package com.example.spindie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
/*
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

        //if not authenticated, then register through google
        FirebaseAuth myAuth = FirebaseAuth.getInstance();
        FirebaseUser user = myAuth.getCurrentUser();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(user!=null) {
                    //Go to menu Fragment
                }
                else{
                    Intent goToRegister = new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(goToRegister);
                }
            }
        }, 2000);

*/
    }
}