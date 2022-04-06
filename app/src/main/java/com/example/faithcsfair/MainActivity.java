package com.example.faithcsfair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView loginScreen;
    Button login;
    TextView signIn;
    TextView signup;
    EditText emailAddress;
    EditText enterPassword;
    public static final String TAG = "mainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginScreen = findViewById(R.id.loginScreen);
        login = findViewById(R.id.login);
        signIn = findViewById(R.id.signIn);
        signup = findViewById(R.id.signup);
        emailAddress = findViewById(R.id.emailAddress);
        enterPassword = findViewById(R.id.enterPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mainToUserInformation = new Intent(MainActivity.this, userInformation.class);
                startActivity(mainToUserInformation);
            }
        });
        Firebase.initializeApp(this);
        Firebase database = new Firebase.getInstance();
        DatabaseReference myRef = database.getReference("weight");
        DatabaseReference myRef2 = database.getReference("height");
        DatabaseReference myRef3 = database.getReference("fitness level");

    }
     myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            String value = dataSnapshot.getValue(weight.toString());
            Log.d(TAG, "Value is: " + value);
            myRef.setValue(value);
        }
    }
}