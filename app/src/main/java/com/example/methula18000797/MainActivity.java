package com.example.methula18000797;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //declare buttons
    Button stdregg, regg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stdregg = findViewById(R.id.stdreg);
        regg = findViewById(R.id.reg);
        //student registartion
        //stdregg.setOnClickListener(new View.OnClickListener() {
          //  @Override
          //  public void onClick(View view) {
            //change to student registartion screen
             //   startActivity(new Intent(MainActivity.this,MainActivitySR.class));
           // }
       // });
        //registtry side
        regg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change to registry screen
                Intent i = new Intent(MainActivity.this, MainActivityREG.class);
                startActivity(i);

            }
        });

    }

    public void gotoStudentReg(View view) {

        Intent i = new Intent(MainActivity.this, MainActivitySR.class);
        startActivity(i);

    }
}