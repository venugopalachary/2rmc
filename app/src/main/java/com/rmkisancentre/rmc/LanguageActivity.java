package com.rmkisancentre.rmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageActivity extends AppCompatActivity {

    Button accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        accept=findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LanguageActivity.this, LoginActivity.class);
                startActivity(i); // invoke the SecondActivity.
                finish(); // the current activity will get finished.

            }
        });

    }
}