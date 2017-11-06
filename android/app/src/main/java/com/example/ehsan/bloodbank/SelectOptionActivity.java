package com.example.ehsan.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectOptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner,spinner2;
    EditText district;
    private static final String[]paths = {"ALL","A+ve","A-ve", "B+","B-ve","AB+ve","AB-ve", "O+ve","O-ve"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);
      /*
        if(Data.flaglogin==false)
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();

        }
        */


        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(SelectOptionActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                Data.BloodGroupFilter= "All";
              //  Toast.makeText(this, "ALL selected", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Data.BloodGroupFilter= "Apos";
                break;
            case 2:
                Data.BloodGroupFilter= "Aneg";
                //Toast.makeText(this, "O+", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Data.BloodGroupFilter= "Bpos";
                break;
            case 4:
                Data.BloodGroupFilter= "Bneg";
                //Toast.makeText(this, "O+", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Data.BloodGroupFilter= "ABpos";
                break;
            case 6:
                Data.BloodGroupFilter= "ABneg";
                //Toast.makeText(this, "O+", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Data.BloodGroupFilter= "Opos";
                break;
            case 8:
                Data.BloodGroupFilter= "Oneg";
                //Toast.makeText(this, "O+", Toast.LENGTH_SHORT).show();
                break;



        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void searchClicked(View v)
    {

        Intent intent = new Intent(this, SelectDistrictActivity.class);
        startActivity(intent);


    }
    public void profileClicked(View v)
    {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);


    }
}
