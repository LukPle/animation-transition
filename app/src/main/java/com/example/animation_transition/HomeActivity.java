package com.example.animation_transition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This Activity shows the user a TextView which tells them that they entered the app.
 * There is also a Button for going back to the MainActivity.
 *
 * Layout File: activity_home.xml
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logoutButton = findViewById(R.id.button_logout);
        logoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}