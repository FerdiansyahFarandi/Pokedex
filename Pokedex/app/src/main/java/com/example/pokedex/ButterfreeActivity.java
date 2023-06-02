package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ButterfreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfree);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void buttonbutterfree2(View view) {
        Intent explicit = new Intent(this, ElemenActivity.class);
        startActivity(explicit);
    }

    public void buttonbutterfree1(View view) {
        Intent explicit = new Intent(this, ElemenActivity.class);
        startActivity(explicit);
    }
}