package com.example.gadsleaderboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.gadsleaderboard.api.HeroAppClient;
import com.example.gadsleaderboard.api.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private EditText projectLink;
    AlertDialog checkDialog, fallDialog, successDialog;
    private AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar != null;
        supportActionBar.setTitle(null);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        Button submitButton = findViewById(R.id.submit_btn);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        emailAddress = findViewById(R.id.email_address);
        projectLink = findViewById(R.id.github_link);
        dialogBuilder = new AlertDialog.Builder(this);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCheckDialog();
            }
        });
    }

    private void showCheckDialog() {
        View layoutView = getLayoutInflater().inflate(R.layout.make_sure_dialog, null);
        ImageView closedDialogIcon = layoutView.findViewById(R.id.close_icon);
        Button yesButton = layoutView.findViewById(R.id.yest_btn);
        dialogBuilder.setView(layoutView);
        checkDialog = dialogBuilder.create();
        checkDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        closedDialogIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDialog.dismiss();
            }
        });
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDialog.dismiss();
                postProject();
            }
        });
        checkDialog.show();
    }

    private void postProject() {
        HeroAppClient mClient = ServiceGenerator.createService(HeroAppClient.class);
        Call<Void> call = mClient.postProject(
                emailAddress.getText().toString(),
                firstName.getText().toString(),
                lastName.getText().toString(),
                projectLink.getText().toString());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: "+ response);
                showSuccessDialog();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t);
                showFallDialog();
            }
        });
    }

    private void showFallDialog() {
        View layoutView = getLayoutInflater().inflate(R.layout.post_error_dialog, null);
        dialogBuilder.setView(layoutView);
        fallDialog = dialogBuilder.create();
        fallDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        fallDialog.show();
    }

    private void showSuccessDialog() {
        View layoutView = getLayoutInflater().inflate(R.layout.post_sucess_diolog, null);
        dialogBuilder.setView(layoutView);
        successDialog = dialogBuilder.create();
        successDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        successDialog.show();
    }
}