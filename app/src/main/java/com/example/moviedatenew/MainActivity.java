package com.example.moviedatenew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moviedatenew.ui.JewelleryActivity;
import com.example.moviedatenew.ui.WatchActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {




    private Button RingButton,WatchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign these 4 variables to the ID's defined in the xml layout

        RingButton =findViewById(R.id.btnRing);
        WatchButton =findViewById(R.id.btnWatch);


        RingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, JewelleryActivity.class);
                startActivity(intent);

            }
        });

        WatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, WatchActivity.class);
                startActivity(intent);

            }
        });

    }
}
