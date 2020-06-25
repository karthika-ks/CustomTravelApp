package com.example.mytravelapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mytravelapp.controller.RESTClient;

public class MainActivity extends AppCompatActivity {

    private Button btnGetAccessToken;
    private TextView txtAccessToken;
    private RESTClient restClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restClient = RESTClient.getInstance();
        btnGetAccessToken = findViewById(R.id.btn_get_access_token);
        txtAccessToken = findViewById(R.id.access_token);
        btnGetAccessToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accessToken = restClient.getAccessToken();
                txtAccessToken.setText(accessToken);
                restClient.getLocations("kors");
            }
        });
    }
}
