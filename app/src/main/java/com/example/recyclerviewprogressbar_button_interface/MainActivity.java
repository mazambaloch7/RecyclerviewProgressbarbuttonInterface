package com.example.recyclerviewprogressbar_button_interface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements Recyclerview_Interface{


    RecyclerView recyclerView ;
    RecyclerviewAdapter adapter;
    Model[] modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        modelList = new  Model[]{
                new Model(R.drawable.ic_launcher_background, "asdf","0"),
                new Model(R.drawable.ic_launcher_background, "asdf","10"),
                new Model(R.drawable.ic_launcher_background, "asdf","30"),
                new Model(R.drawable.ic_launcher_background, "asdf","0"),
                new Model(R.drawable.ic_launcher_background, "asdf","0"),
                new Model(R.drawable.ic_launcher_background, "asdf","0"),
                new Model(R.drawable.ic_launcher_background, "asdf","0"),

        };


        recyclerView = findViewById(R.id.recyclerivew);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerviewAdapter(this,modelList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



    }


    @Override
    public void onRowClick(int position) {
        Log.d("msg","onRowClick views");

//        this is Row is clicked
        Toast.makeText(this, "this is   Row is clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewclick(int position, View view) {

        if (view.getId() == R.id.action_image){
            Log.d("msg","Image views");
            Toast.makeText(this, "Click on Button", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.textview){
            Log.d("msg","textview views");

            Toast.makeText(this, "Click on textview", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "View are not clickalbe", Toast.LENGTH_SHORT).show();
        }
        

    }



}
