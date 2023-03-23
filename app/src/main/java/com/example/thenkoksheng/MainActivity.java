package com.example.thenkoksheng;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button startgame;
    private Button leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the id from the main menu design layout

        startgame = findViewById(R.id.buttons1);
        leaderboard = findViewById(R.id.buttons2);

        //assign onclicklistner to button

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start by using intent function to link all the different activity
                Intent it = new Intent(MainActivity.this , levelselect.class);
                startActivity(it);
                finish();


            }
        });

        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent it = new Intent(mainmenu.this , )
            }
        });

    }


}