package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Abra");
        list.add("Beedril");
        list.add("Blastoise");
        list.add("Butterfree");
        list.add("Caterpie");
        list.add("Charizard");
        list.add("Charmaleon");
        list.add("Ditto");
        list.add("Jigglypuff");
        list.add("Kadabra");
        list.add("Pidgeot");
        list.add("Pikachu");
        list.add("Rattata");
        list.add("Sandshrew");
        list.add("Squirtle");
        list.add("wiglgypuff");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             if(position==0){
                startActivity(new Intent(ListviewActivity.this,AbraActivity.class));
             }else if(position==1){
                startActivity(new Intent(ListviewActivity.this,BeedrillActivity.class));
             }else if(position==2){
                 startActivity(new Intent(ListviewActivity.this,BlastoiseActivity.class));
             }else if(position==3){
                 startActivity(new Intent(ListviewActivity.this,ButterfreeActivity.class));
             }else if (position==4){
                 startActivity(new Intent(ListviewActivity.this,CaterpieActivity.class));
             }else if (position==5){
                 startActivity(new Intent(ListviewActivity.this,CharizardActivity.class));
             }else if (position==6){
                 startActivity(new Intent(ListviewActivity.this,CharmaleonActivity.class));
             }else if (position==7){
                 startActivity(new Intent(ListviewActivity.this,DittoActivity.class));
             }else if (position==8){
                 startActivity(new Intent(ListviewActivity.this,JigglypuffActivity.class));
             }else if (position==9){
                 startActivity(new Intent(ListviewActivity.this,KadabraActivity.class));
             }else if (position==10){
                 startActivity(new Intent(ListviewActivity.this,PidgeotActivity.class));
             }else if (position==11){
                 startActivity(new Intent(ListviewActivity.this,PikachuActivity.class));
             }else if (position==12){
                 startActivity(new Intent(ListviewActivity.this,RattataActivity.class));
             }else if (position==13){
                 startActivity(new Intent(ListviewActivity.this,SandshrewActivity.class));
             }else if (position==14){
                 startActivity(new Intent(ListviewActivity.this,SquirtleActivity.class));
             }else if (position==15){
                 startActivity(new Intent(ListviewActivity.this,WigglypuffActivity.class));
             }
            }
        });

    }
}