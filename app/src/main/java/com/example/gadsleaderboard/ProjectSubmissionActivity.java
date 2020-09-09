package com.example.gadsleaderboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gadsleaderboard.api.HeroAppClient;
import com.example.gadsleaderboard.api.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private HeroAppClient mClient;
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private EditText projectLink;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(null);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        submitButton = findViewById(R.id.submit_btn);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        projectLink = findViewById(R.id.github_link);
        postProject();
    }

    private void postProject() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClient = ServiceGenerator.createService(HeroAppClient.class);
                Call<Void> call = mClient.postProject(
                        emailAddress.getText().toString(),
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        projectLink.getText().toString());
              call.enqueue(new Callback<Void>() {
                  @Override
                  public void onResponse(Call<Void> call, Response<Void> response) {
                      Log.d(TAG, "onResponse: "+ response);
                  }

                  @Override
                  public void onFailure(Call<Void> call, Throwable t) {
                      Log.d(TAG, "onFailure: "+ t);
                  }
              });
            }
        });
    }
}