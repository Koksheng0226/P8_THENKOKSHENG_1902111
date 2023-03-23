package com.example.thenkoksheng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class levelselect extends AppCompatActivity {

    private Button level1button;
    private Button level2button;
    private Button level3button;
    private Button level4button;
    private Button level5button;

    //create to start the level
    private void startgame(int lv){

        Intent it = new Intent(this , mainmenu.class);
        it.putExtra("level" , lv);
        startActivity(it);
        finish();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelselect);

        level1button = findViewById(R.id.level1);
        level2button = findViewById(R.id.level2);
        level3button = findViewById(R.id.level3);
        level4button = findViewById(R.id.level4);
        level5button = findViewById(R.id.level5);

        level1button.setOnClickListener(v -> startgame(1));

        level2button.setOnClickListener(v -> startgame(2));

        level3button.setOnClickListener(v -> startgame(3));

        level4button.setOnClickListener(v -> startgame(4));

        level5button.setOnClickListener(v -> startgame(5));


    }


}
