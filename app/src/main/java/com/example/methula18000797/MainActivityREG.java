package com.example.methula18000797;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityREG extends AppCompatActivity {
    Button stdss, femm, malee, fac_btt, prog_btt, id_btt;
    EditText id_txtt, fac_txtt, prog_txtt;
    TextView displayy;
    View v;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        //assigning xml to main class
        stdss = findViewById(R.id.stds);
        femm = findViewById(R.id.fem);
        malee = findViewById(R.id.male);
        fac_btt = findViewById(R.id.fac_bt);
        fac_txtt = findViewById(R.id.fac_txt);
        prog_btt = findViewById(R.id.prog_bt);
        id_btt = findViewById(R.id.id_bt);
        id_txtt = findViewById(R.id.id_txt);
        prog_txtt = findViewById(R.id.prog_txt);
        displayy = findViewById(R.id.display);
        dbHandler = new DBHandler(MainActivityREG.this);

        //getting single student
        id_btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = id_txtt.getText().toString();

                displayy.setText(dbHandler.getDetails(id).toString());
            }
        });

        //getting all students
        stdss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                displayy.setText(dbHandler.getAll().toString());
            }
        });

        //getting male students
        malee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayy.setText(dbHandler.getMales().toString());
            }
        });

        //getting females
        femm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayy.setText(dbHandler.getFemales().toString());
            }
        });

        //getting from a faculty
        fac_btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = fac_txtt.getText().toString();
                displayy.setText(dbHandler.getFaculty(input).toString());
            }
        });

        //getting from a programme
        prog_btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = prog_txtt.getText().toString();
                displayy.setText(dbHandler.getMales().toString());
            }
        });


    }
}