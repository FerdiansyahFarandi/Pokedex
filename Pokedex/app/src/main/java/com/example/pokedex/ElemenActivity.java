package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElemenActivity extends AppCompatActivity {

    Button bug, fairy, fire, flying, electric, normal, poison, psychic, water;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        bug = (Button) findViewById(R.id.bugbutton);
        fairy = (Button) findViewById(R.id.fairybutton);
        flying = (Button) findViewById(R.id.flyingbutton);
        fire = (Button) findViewById(R.id.firebutton);
        electric = (Button) findViewById(R.id.electricbutton);
        normal = (Button) findViewById(R.id.normalbutton);
        poison = (Button) findViewById(R.id.poisonbutton);
        psychic = (Button) findViewById(R.id.psychicbutton);
        water = (Button) findViewById(R.id.waterbutton);

        bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new BugFragment()); }
        });
        fairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new FairyFragmentActivity()); }
        });
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new FireFragmentActivity()); }
        });
        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new ElectricFragmentActivity()); }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new NormalActivity()); }
        });
        poison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new PoisonFragmentActivity()); }
        });
        psychic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new PsychicFragmentActivity()); }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new WaterFragmentActivity()); }
        });
        flying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {loadFragment(new FlyingFragmentActivity()); }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }

}