package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    ImageView Abra;
    ImageView Beedrill;
    ImageView Blastoise;
    ImageView Butterfree;
    ImageView Caterpie;
    ImageView Charizard;
    ImageView Charmaleon;
    ImageView Ditto;
    ImageView Jigglypuff;
    ImageView Kadabra;
    ImageView Pidgeot;
    ImageView Pikachu;
    ImageView Rattata;
    ImageView Sandshrew;
    ImageView Squirtle;
    ImageView Wigglypuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Abra = findViewById(R.id.abra);
        Beedrill = findViewById(R.id.beedrill);
        Blastoise = findViewById(R.id.blastoise);
        Butterfree = findViewById(R.id.butterfree);
        Caterpie = findViewById(R.id.caterpie);
        Charizard = findViewById(R.id.charizard);
        Charmaleon = findViewById(R.id.charmaleon);
        Ditto = findViewById(R.id.ditto);
        Jigglypuff = findViewById(R.id.jigglypuff);
        Kadabra = findViewById(R.id.kadabra);
        Pidgeot = findViewById(R.id.pidgeot);
        Pikachu = findViewById(R.id.pikachu);
        Rattata = findViewById(R.id.rattata);
        Sandshrew = findViewById(R.id.sandshrew);
        Squirtle = findViewById(R.id.squirtle);
        Wigglypuff = findViewById(R.id.wigglypuff);
    }

    public void ExplicitAbra(View view) {
        Intent explicit = new Intent(this, AbraActivity.class);
        startActivity(explicit);

    }

    public void ExplicitBeedrill(View view) {
        Intent explicit = new Intent(this, BeedrillActivity.class);
        startActivity(explicit);
    }

    public void ExplicitBlastoise(View view) {
        Intent explicit = new Intent(this, BlastoiseActivity.class);
        startActivity(explicit);
    }

    public void ExplicitBUtterfree(View view) {
        Intent explicit = new Intent(this, ButterfreeActivity.class);
        startActivity(explicit);
    }

    public void ExplicitCaterpie(View view) {
        Intent explicit = new Intent(this, CaterpieActivity.class);
        startActivity(explicit);
    }

    public void ExplicitCharizard(View view) {
        Intent explicit = new Intent(this, CharizardActivity.class);
        startActivity(explicit);
    }

    public void ExplicitCharmaleon(View view) {
        Intent explicit = new Intent(this, CharmaleonActivity.class);
        startActivity(explicit);
    }

    public void ExplicitDitto(View view) {
        Intent explicit = new Intent(this, DittoActivity.class);
        startActivity(explicit);
    }

    public void ExplicitJigglypuff(View view) {
        Intent explicit = new Intent(this, JigglypuffActivity.class);
        startActivity(explicit);
    }

    public void ExplicitKadabra(View view) {
        Intent explicit = new Intent(this, KadabraActivity.class);
        startActivity(explicit);
    }

    public void ExplicitPidgeot(View view) {
        Intent explicit = new Intent(this, PidgeotActivity.class);
        startActivity(explicit);
    }

    public void ExplicitPikachu(View view) {
        Intent explicit = new Intent(this, PikachuActivity.class);
        startActivity(explicit);
    }

    public void ExplicitRattata(View view) {
        Intent explicit = new Intent(this, RattataActivity.class);
        startActivity(explicit);
    }

    public void ExplicitSandshrew(View view) {
        Intent explicit = new Intent(this, SandshrewActivity.class);
        startActivity(explicit);
    }

    public void ExplicitSquirtle(View view) {
        Intent explicit = new Intent(this, SquirtleActivity.class);
        startActivity(explicit);
    }

    public void ExplicitWigglypuff(View view) {
        Intent explicit = new Intent(this, WigglypuffActivity.class);
        startActivity(explicit);
    }

    public void ExpicitKamera(View view) {
        Intent explicit = new Intent(this, KameraActivity.class);
        startActivity(explicit);
    }

    public void buttonacc(View view) {
        Intent explicit = new Intent(this, EditorActivity.class);
        startActivity(explicit);
    }

    public void kelistview(View view) {
        Intent explicit = new Intent(this, ListviewActivity.class);
        startActivity(explicit);
    }
}