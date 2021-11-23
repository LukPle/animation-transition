package com.example.animation_transition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This Activity creates a Log In Screen.
 * The user can click on one of three Buttons for completing the log in process.
 * Each Button triggers a different animation for the transition to the next Activity.
 *
 * Layout File: activity_main.xml
 * Animation Files are in the Folder R.anim
 *
 * @author Lukas Plenk
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButtonStandard, loginButtonPredefined, loginButtonCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButtonStandard = findViewById(R.id.button_login_standard);
        loginButtonPredefined = findViewById(R.id.button_login_predefined);
        loginButtonCustom = findViewById(R.id.button_login_custom);

        loginButtonStandard.setOnClickListener(this);
        loginButtonPredefined.setOnClickListener(this);
        loginButtonCustom.setOnClickListener(this);
    }

    /**
     * This method creates an Intent for transitioning to the HomeActivity.
     * The class ActivityOptions is used for giving a specific animation to the Intent.
     * A switch case decides which Button was clicked on and which animation should trigger.
     * @param view is a specific UI element that was clicked on.
     */
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(MainActivity.this, HomeActivity.class);

        ActivityOptions activityOptions;

        switch (view.getId()) {

            case R.id.button_login_standard:
                activityOptions = ActivityOptions.makeBasic();
                startActivity(intent, activityOptions.toBundle());
                break;

            case R.id.button_login_predefined:
                activityOptions = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getWidth(), view.getHeight());
                startActivity(intent, activityOptions.toBundle());
                break;
                
            case R.id.button_login_custom:
                activityOptions = ActivityOptions.makeCustomAnimation
                        (MainActivity.this, R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent, activityOptions.toBundle());
                break;
        }
    }
}