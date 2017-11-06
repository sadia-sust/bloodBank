package com.example.ehsan.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectDistrictActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_district);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("BAGERHAT");
        categories.add("BANDARBAN");
        categories.add("BARGUNA");
        categories.add("BARISAL");
        categories.add("BHOLA");
        categories.add("BOGRA");
        categories.add("BRAHMANBARIA");
        categories.add("CHANDPUR");
        categories.add("CHAPAINABABGANJ");
        categories.add("CHITTAGONG");
        categories.add("CHUADANGA");
        categories.add("COMILLA");
        categories.add("COX'S BAZAR");
        categories.add("DHAKA");
        categories.add("DINAJPUR");
        categories.add("FARIDPUR");
        categories.add("FENI");
        categories.add("GAIBANDHA");
        categories.add("GAZIPUR");
        categories.add("GOPALGANJ");
        categories.add("HABIGANJ");
        categories.add("JAMALPUR");
        categories.add("JESSORE");
        categories.add("JHALOKATI");
        categories.add("JHENAIDAH");
        categories.add("JOYPURHAT");
        categories.add("KHAGRACHHARI");
        categories.add("KHULNA");
        categories.add("KISHOREGONJ");
        categories.add("KURIGRAM");
        categories.add("KUSHTIA");
        categories.add("LAKSHMIPUR");
        categories.add("LALMONIRHAT");
        categories.add("MADARIPUR");
        categories.add("MAGURA");
        categories.add("MANIKGANJ");
        categories.add("MAULVIBAZAR");
        categories.add("MEHERPUR");
        categories.add("MUNSHIGANJ");
        categories.add("MYMENSINGH");
        categories.add("NAOGAON");
        categories.add("NARAIL");
        categories.add("NARAYANGANJ");
        categories.add("NARSINGDI");
        categories.add("NATORE");
        categories.add("NETRAKONA");
        categories.add("NILPHAMARI");
        categories.add("NOAKHALI");
        categories.add("PABNA");
        categories.add("PANCHAGARH");
        categories.add("PATUAKHALI");
        categories.add("PIROJPUR ");
        categories.add("RAJBARI");
        categories.add("RAJSHAHI");
        categories.add("RANGAMATI ");
        categories.add("RANGPUR");
        categories.add("SATKHIRA");
        categories.add("SHARIATPUR");
        categories.add("SHERPUR");
        categories.add("SIRAJGANJ");
        categories.add("SUNAMGANJ");
        categories.add("SYLHET");
        categories.add("TANGAIL");
        categories.add("THAKURGAON");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        Data.DistrictFilter= item;
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void finalsearchClicked(View v)
    {

        Intent intent = new Intent(this, BloodListActivity.class);
        startActivity(intent);


    }
}
