package com.example.methula18000797;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class MainActivitySR extends AppCompatActivity {
        Button regg;
        EditText fnamee, lnamee,dobb, genderr, paa, emaill, contt, nokk, cnokk, facc, progg;
        View v;

        private DBHandler dbHandler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sr);

            //setting buttons
            fnamee = v.findViewById(R.id.fname);
            lnamee = v.findViewById(R.id.lname);
            dobb = v.findViewById(R.id.dob);
            genderr = v.findViewById(R.id.gender);
            paa = v.findViewById(R.id.pa);
            emaill = v.findViewById(R.id.email);
            contt = v.findViewById(R.id.cont);
            nokk = v.findViewById(R.id.nok);
            cnokk = v.findViewById(R.id.cnok);
            facc = v.findViewById(R.id.fac);
            progg = v.findViewById(R.id.prog);
            regg = v.findViewById(R.id.reg);
            dbHandler = new DBHandler(MainActivitySR.this);

            //get string input from all edits
            final String FNAME = fnamee.getText().toString();
            final String LNAME = lnamee.getText().toString();
            final String DOB = dobb.getText().toString();
            final String GENDER = genderr.getText().toString();
            final String PA = paa.getText().toString();
            final String EMAIL = emaill.getText().toString();
            final String CONT = contt.getText().toString();
            final String NOK = nokk.getText().toString();
            final String CNOK = cnokk.getText().toString();
            final String FAC = facc.getText().toString();
            final String PROG = progg.getText().toString();

            //school email and ID
            final String SEMAIL = LNAME + FNAME + "@seabo.com";
            final String ID = "2021" + LNAME;
            regg = v.findViewById(R.id.reg);

            regg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(FNAME.isEmpty() && LNAME.isEmpty()&&DOB.isEmpty()&&GENDER.isEmpty()&&PA.isEmpty()&& EMAIL.isEmpty()&&CONT.isEmpty()
                            && NOK.isEmpty()&&CNOK.isEmpty()&&FAC.isEmpty()&&PROG.isEmpty())
                    {
                        Toast.makeText(MainActivitySR.this, "Empty field", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    //ADDING VALUES TO DATABASE
                    dbHandler.add(FNAME,LNAME,DOB, GENDER,PA,EMAIL,CONT,NOK,CNOK,FAC,PROG,SEMAIL,ID);

                }
            });

        }
    }
