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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText e1,e2,e3,e4,e5;
    Spinner spinner3;
    String locat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Spinner spinner = (Spinner) findViewById(R.id.spinner3);

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
    public void registerClicked(View v)
    {
        e1= (EditText) findViewById(R.id.editText2);
        e2= (EditText) findViewById(R.id.editText3);
        e3= (EditText) findViewById(R.id.editText4);

        e5= (EditText) findViewById(R.id.editText6);
        String nm = e1.getText().toString();
        String gr = e5.getText().toString();
        String mb = e2.getText().toString();
        String ps = e3.getText().toString();



        String url=Data.IPAdress+"/blood/register.php?name="+
        nm+"&pass="+ps+"&loc="+locat+"&grp="+gr+"&mob="+mb;


        Toast.makeText(getApplicationContext(),url, Toast.LENGTH_SHORT).show();

        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            JSONArray jsonArray = response;
                          //  Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_SHORT).show();

                            for (int i = 0; i < jsonArray.length(); ++i) {
                                JSONObject jsonObject = null;
                                jsonObject = jsonArray.getJSONObject(i);

                                //  arrayList1.add(jsonObject.getString("id"));
                                Data.fullname.add(jsonObject.getString("name"));
                                Data.mobile.add(jsonObject.getString("contact_no"));
                                Data.group.add(jsonObject.getString("blood_group"));
                                Data.password.add(jsonObject.getString("PASSWORD"));
                                Data.location.add(jsonObject.getString("location"));


                                //   arrayList3.add(jsonObject.getString("phone"));
                                // arrayList4.add(jsonObject.getString("blood"));
                                //  arrayList5.add(jsonObject.getString("dept"));


                            }

                            //  Toast.makeText(getApplicationContext(), Integer.toString( Data.password.size()), Toast.LENGTH_SHORT).show();


                        }catch (JSONException e) {

                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Toast.makeText(getApplicationContext(),"baal"+ Integer.toString( Data.password.size()), Toast.LENGTH_SHORT).show();

                ;
                //    pDialog.hide();
            }
        });

        queue.add(jsonObjectRequest);



            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        locat = item;
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
