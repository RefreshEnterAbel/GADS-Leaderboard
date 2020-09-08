package com.example.gadsleaderboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ProjectSubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(null);
        supportActionBar.setDisplayHomeAsUpEnabled(true);

    }
}